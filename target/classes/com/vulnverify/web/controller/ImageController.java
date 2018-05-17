/**
 * 
 */
package com.vulnverify.web.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.vulnverify.core.entity.PageData;
import com.vulnverify.core.entity.PageQuery;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.web.model.TImage;
import com.vulnverify.web.model.requestbody.ImageAddReqBody;
import com.vulnverify.web.model.requestbody.ImageListReqBody;
import com.vulnverify.web.model.view.ImageView;
import com.vulnverify.web.service.ImageService;

import tns.Application;

import com.vulnverify.core.utils.ApplicationUtils;
import com.vulnverify.core.utils.CxfInvokeUtil;
import com.vulnverify.core.utils.FileUtil;

/**
 * 镜像管理控制器
 * @author luoxiao
 *
 */
@Controller
@RequestMapping(value = "/image")
public class ImageController extends BaseController{

	private Logger logger = Logger.getLogger(RootController.class);

	@Autowired
	private ImageService imageService;
	
	/**
	 * 镜像列表
	 * 
	 * @param request 请求体
	 * @return 返回常用数据
	 * @throws Exception 异常
	 */  
	@ResponseBody
	@RequestMapping(value = "/imageList", method = RequestMethod.POST)
	public Object list(@RequestBody PageQuery<ImageListReqBody> pageQuery) throws Exception {
		
		logger.info("请求镜像列表。");
		
        // 请求云平台接口
        Object[] args = new Object[] {""};
        ArrayList<LinkedHashMap<String, String>> data = new ArrayList<LinkedHashMap<String, String>>(); 
        data = CxfInvokeUtil.callCloudServcie("getImages", args, data); 
        if(data == null) {
        	logger.error("获取云平台getImages接口失败。");
        }
       
        int updatedRecords = 0;
        int insertedRecords = 0;
        
        // 遍历云平台镜像
        for(LinkedHashMap<String, String> cloudImage : data) {
        	String uuid = cloudImage.get("uuid");
        	       	
        	// 请求云平台接口
            args = new Object[] {uuid};
            LinkedHashMap<String, String> cloudImageDetail = new LinkedHashMap<String, String>(); 
            cloudImageDetail = CxfInvokeUtil.callCloudServcie("getImageDetails", args, cloudImageDetail); 
            if(cloudImageDetail == null) {
            	logger.error("获取云平台getImageDetails接口失败。");
            }        	
        	
        	// 入库        
        	HashMap<String, String> getCountArg = new HashMap<String, String>();
        	getCountArg.put("uuid", cloudImage.get("uuid"));
        	getCountArg.put("state", cloudImage.get("state"));
        	if(imageService.getCountByState(getCountArg) > 0){
        		TImage image = new TImage();
            	image.setImageUuid(cloudImage.get("uuid"));
            	image.setStatus(cloudImage.get("state"));
            	image.setUpdateTime(new Date());
            	int insertResult = imageService.updateByUUID(image);
	        	if(insertResult <= 0)
	        		logger.error("更新云平台镜像数据失败：" + image.toString());
	        	else {
	        		logger.info("更新云平台镜像数据：" + image.toString());
	        		updatedRecords++;
	        	}
        	}
        	else if(imageService.getCount(getCountArg) <= 0){
        		TImage image = new TImage();
            	image.setImageUuid(cloudImage.get("uuid"));
            	image.setImageName(cloudImage.get("uuid"));  //云平台返回的name是镜像文件名且可重复，不同于数据库中的IMAGE_NAME字段。
            	image.setStatus(cloudImage.get("state"));
            	image.setOs(cloudImageDetail.get("ostype"));
            	image.setDescription(cloudImageDetail.get("description"));
            	image.setContainerFormat(cloudImageDetail.get("container_format"));
            	image.setDiskFormat(cloudImageDetail.get("disk_format"));
            	image.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(cloudImageDetail.get("created_at")));
            	int insertResult = imageService.insert(image);
	        	if(insertResult <= 0)
	        		logger.error("新建云平台镜像数据失败：" + image.toString());
	        	else {
	        		logger.info("新建云平台镜像数据：" + image.toString());
	        		insertedRecords++;
	        	}
        	}
        }
        
        logger.info("同步云平台镜像数据，新建：" + insertedRecords + "条，更新：" + updatedRecords + "条。");
        
        // 搜库
		Page<ImageView> page = generatePage(pageQuery);
		imageService.getList(page, pageQuery.getQueryInfo());
		for(ImageView iv : page.getResult()) {
			iv.setCreateTime( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(iv.getCreateTime1()));
			iv.setFileSize(FileUtil.convertSize(iv.getFileSize1()));
		}
		PageData<ImageView> generatePageData = generatePageData(page);
		return generatePageData;
	}

	/**
	 * 添加镜像
	 * 
	 * @param request 请求体
	 * @return 返回常用数据
	 * @throws Exception 异常
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(@Valid @RequestBody  ImageAddReqBody request, HttpSession session) throws Exception {
		
		logger.info("添加镜像。");
		
		// 验证是否已经存在相同名称的记录
		HashMap<String, String> getCountArg = new HashMap<String, String>();
    	getCountArg.put("uuid", request.getUUID());
    	getCountArg.put("imageName", request.getImageName());
		if(imageService.getCount(getCountArg) > 0)
			return this.generateFailedData(null, "已经存在相同名称或文件的镜像，不能再次创建。");
		
		// 获取已上传的镜像文件
		File tarFile = null;
		String uuid = request.getUUID();		
		if(uuid != null && !uuid.isEmpty()) {
			String imageFileUploadPath = ApplicationUtils.getProperty("imageFileUploadPath");
			tarFile = findFile(uuid, imageFileUploadPath);
		}
		if(tarFile == null){
			return this.generateFailedData(null, "指定的镜像文件不存在，不能完成创建。");
		}
		
		// 请求云平台接口createImage
        Object[] args = new Object[] {tarFile.getName(), request.getDescription(), request.getOS(), "docker", "raw"};
        LinkedHashMap<String, String> data = new LinkedHashMap<String, String>(); 
        data = CxfInvokeUtil.callCloudServcie("createImage", args, data); 
        if(data == null) {
        	return this.generateFailedData(null, "创建失败。");
        }
        
        // 请求云平台接口createImagePost
        Object[] args2 = new Object[] {data.get("uuid"), data.get("path")};
        Object data2 = new Object();
        data2 = CxfInvokeUtil.callCloudServcie("createImagePost", args2, data2);
        if(data2 == null) {
        	return this.generateFailedData(null, "创建失败。");
        }
				
		// 入库
		TImage model = new TImage();
		model.setImageName(request.getImageName());
		model.setOs(request.getOS());
		model.setSoftware(request.getSoftware());
		model.setEnviroment(request.getEnviroment());
		model.setDescription(request.getDescription());			
		model.setImageUuid(data.get("uuid"));
		model.setImageFilePath(data.get("path"));
		model.setImageFileSize(tarFile.length());
		model.setContainerFormat("docker");
		model.setDiskFormat("raw");
		model.setCreateTime(new Date());   
		int insertResult = imageService.insert(model);
		if(insertResult <= 0)
			return this.generateFailedData(null, "创建失败。");
		return generateResultData();
	}

	/**
	 * 根据uuid搜索上传的tar文件
	 * @param uuid
	 * @param uuidPath
	 * @return
	 */
	private File findFile(String uuid, String path) {
		File file = new File(path);
		if(file.exists()){
			File[] files = file.listFiles();
			for(File f : files) {
				if(f.isFile() && f.getName().lastIndexOf(".tar") == f.getName().length()-4) {
					return f;
				}
			}
		}
		return null;
	}
	
	/**
	 * 上传镜像文件
	 *
	 */
	@ResponseBody
	@RequestMapping(value="/uploadFile", method=RequestMethod.POST)
    public Object uploadImageFile(@RequestParam("uploadFile")  MultipartFile uploadFile, HttpSession session) throws Exception{
		
		logger.info("上传镜像文件。");
		
		if(uploadFile.getSize() <= 0)
			return generateFailedData(null, "镜像文件不能为空。");
		
    	String fileName = uploadFile.getOriginalFilename();
    	if(fileName.lastIndexOf(".tar") != fileName.length()-4)
    		return generateFailedData(null, "镜像文件必须是tar文件。");
    	
    	String uuid = UUID.randomUUID().toString();
    	String imageFileUploadPath = ApplicationUtils.getProperty("imageFileUploadPath");
    	File file = new File(imageFileUploadPath);
    	if(!file.mkdirs())
    		return generateFailedData(null, "保存镜像文件失败。");
    	
    	file = new File(imageFileUploadPath, fileName);
    	uploadFile.transferTo(file);
    	return generateResultData(uuid); 
    }
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String temp(HttpServletRequest request) throws Exception {
		RestTemplate client = new RestTemplate();
		return "forward:/uploadfileTest.jsp"; 
	}
}