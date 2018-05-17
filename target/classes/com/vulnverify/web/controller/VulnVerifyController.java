package com.vulnverify.web.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import com.vulnverify.core.entity.PageData;
import com.vulnverify.core.entity.PageQuery;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.core.utils.ApplicationUtils;
import com.vulnverify.web.model.TPatchSolution;
import com.vulnverify.web.model.TVulnVerifyCode;
import com.vulnverify.web.model.TVulnVerifyRecord;
import com.vulnverify.web.model.requestbody.PatchSolutionReqBody;
import com.vulnverify.web.model.requestbody.VulnVerifyCodeReqBody;
import com.vulnverify.web.model.requestbody.VulnVerifyReqBody;
import com.vulnverify.web.model.view.VirtualMachineView;
import com.vulnverify.web.model.view.VulnVerifyView;
import com.vulnverify.web.service.VulnVerifyService;

/**
 * 用户控制类
 * @author zhangdj
 * @date 2018年4月23日  
 *
 */
@Controller
@RequestMapping(value="/vulnVerify")
public class VulnVerifyController extends BaseController{
	
		private static Logger logger=LoggerFactory.getLogger(VulnVerifyController.class);
		@Resource
		private VulnVerifyService  vulnVerifyService;
	
		@RequestMapping(value = "/list")
		@ResponseBody
		public Object list(@RequestBody PageQuery<VulnVerifyReqBody> pageQuery) {
			logger.info("获取漏洞验证列表");
			Page<VulnVerifyView> page = generatePage(pageQuery);

			vulnVerifyService.getList(page, pageQuery.getQueryInfo());

			PageData<VulnVerifyView> generatePageData = generatePageData(page);

			return generatePageData;
		}
		
		@RequestMapping(value = "/addPatch")
		@ResponseBody
		public Object addPatch(MultipartRequest multipartRequest, VulnVerifyReqBody   reqBody) throws Exception{
			logger.info("上传补丁功能");
			try {
				//上传文件
				//String[] fileTitles = vo.getFileTitles();
				List<MultipartFile> files=multipartRequest.getFiles("files");

				TPatchSolution patch = new TPatchSolution();
				patch.setVulnId(new Integer(reqBody.getVulnId())); //漏洞编号
				patch.setVulnName(reqBody.getVulnName());    //漏洞名称
                patch.setPatchName(reqBody.getPatchName());  //补丁名称
				vulnVerifyService.addPatch(files,patch);
			} catch (Exception e) {
				throw e;
				//e.printStackTrace();
			}
			return generateResultData();
		}
		
		@RequestMapping(value = "/queryPatchInfo")
		@ResponseBody
		public Object queryPatchInfo(@RequestBody PatchSolutionReqBody requestBody) {
			logger.info("查询补丁信息功能");
			List<TPatchSolution> list = null;
			try {
				list = vulnVerifyService.queryPatchInfo(requestBody);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return generateResultData(list);
		}
		
		
		@RequestMapping(value = "/addVerifyCode")
		@ResponseBody
		public Object addVerifyCode(List<MultipartFile> files, TVulnVerifyCode verifyCode) {
			logger.info("上传验证代码功能");
			try {
				vulnVerifyService.addVerifyCode(files,verifyCode);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return generateResultData();
		}
		
		@RequestMapping(value = "/queryVerifyCode")
		@ResponseBody
		public Object queryVerifyCode(@RequestBody VulnVerifyCodeReqBody  requestBody) {
			logger.info("查询代码验证信息功能");
			List<TVulnVerifyCode> list = null;
			try {
			    list = vulnVerifyService.queryVerifyCode(requestBody);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return generateResultData(list);
			
		}
		
	/*	
    @RequestMapping("/downloadPatchFile/{fileName}")
    public void downloadPatchFile(@PathVariable String fileName,HttpServletResponse response) throws Exception {
    	 // 下载本地文件
        //String fileName = "A.java".toString(); // 文件的默认保存名
        // 读到流中
        String verifyCodeUploadPath = ApplicationUtils.getProperty("patchFileUploadPath");
        InputStream inStream = new FileInputStream(verifyCodeUploadPath+"/"+fileName);// 文件的存放路径
        // 设置输出的格式
        response.reset();
        response.setContentType("bin");
        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        // 循环取出流中的数据
        byte[] b = new byte[9000];
        int len;
        try {
            while ((len = inStream.read(b)) > 0)
                response.getOutputStream().write(b, 0, len);
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	*/
		
	/*
	 * 下载补丁文件
	 */
    @RequestMapping("/downloadPatchFile/{vulnId}")
    public void downloadPatchFile(@PathVariable String vulnId,HttpServletResponse response) throws Exception {
    	List<TPatchSolution> list = null;
    	PatchSolutionReqBody requestBody = new PatchSolutionReqBody();
		requestBody.setVulnId(vulnId);
		list = vulnVerifyService.queryPatchInfo(requestBody); 
		if(list!=null&&list.size()>0){
			TPatchSolution  patch = list.get(0);
			String fileName  = patch.getFileName();
	        // 读到流中
	        String verifyCodeUploadPath = ApplicationUtils.getProperty("patchFileUploadPath");
	        InputStream inStream = new FileInputStream(verifyCodeUploadPath+"/"+fileName);// 文件的存放路径
	        // 设置输出的格式
	        response.reset();
	        response.setContentType("bin");
	        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	        // 循环取出流中的数据
	        byte[] b = new byte[9000];
	        int len;
	        try {
	            while ((len = inStream.read(b)) > 0)
	                response.getOutputStream().write(b, 0, len);
	            inStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
    } 
    
    

	 /*
	  * 下载验证文件
	  */
	 @RequestMapping("/download/{vulnId}")
	 public void download(@PathVariable String vulnId,HttpServletResponse response) throws Exception {
		List<TVulnVerifyCode> list = null;
		VulnVerifyCodeReqBody requestBody = new VulnVerifyCodeReqBody();
		requestBody.setVulnId(vulnId);
		list = vulnVerifyService.queryVerifyCode(requestBody); 
		if(list!=null&&list.size()>0){
			TVulnVerifyCode  verifyCode = list.get(0);
			String fileName  = verifyCode.getCodeFileName();
			// 读到流中
	        String verifyCodeUploadPath = ApplicationUtils.getProperty("verifyCodeUploadPath");
	        InputStream inStream = new FileInputStream(verifyCodeUploadPath+"/"+fileName);// 文件的存放路径
	        // 设置输出的格式
	        response.reset();
	        response.setContentType("bin");
	        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	        // 循环取出流中的数据
	        byte[] b = new byte[9000];
	        int len;
	        try {
	            while ((len = inStream.read(b)) > 0)
	                response.getOutputStream().write(b, 0, len);
	            inStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
		} 
       
    }

		
	@RequestMapping(value = "/verify")
	@ResponseBody
	public Object verify(@RequestBody VulnVerifyCodeReqBody  requestBody) {
		logger.info("验证功能");
		VirtualMachineView  machine = null;
		try {
		    machine = new VirtualMachineView();
			machine.setIp("192.168.50.98");
			machine.setPort("10001");
			machine.setPwd("vncpassword");
			machine.setStatus("running");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return generateResultData(machine);
	}
	
	@RequestMapping(value = "/save")
	@ResponseBody
	public Object save(@RequestBody TVulnVerifyRecord  requestBody) {
		logger.info("保存功能");
		try {
			requestBody.setVerifyTime(new Date());
			vulnVerifyService.saveVulnVerifyRecord(requestBody);  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return generateResultData();
	}
	
}
