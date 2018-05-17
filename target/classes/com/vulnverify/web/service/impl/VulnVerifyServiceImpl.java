package com.vulnverify.web.service.impl;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.vulnverify.core.generic.GenericDao;
import com.vulnverify.core.generic.GenericServiceImpl;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.core.utils.ApplicationUtils;
import com.vulnverify.web.constant.Constant;
import com.vulnverify.web.dao.TPatchSolutionMapper;
import com.vulnverify.web.dao.TVulnVerifyCodeMapper;
import com.vulnverify.web.dao.TVulnVerifyLibMapper;
import com.vulnverify.web.dao.TVulnVerifyRecordMapper;
import com.vulnverify.web.model.TPatchSolution;
import com.vulnverify.web.model.TVulnVerifyCode;
import com.vulnverify.web.model.TVulnVerifyLib;
import com.vulnverify.web.model.TVulnVerifyRecord;
import com.vulnverify.web.model.requestbody.PatchSolutionReqBody;
import com.vulnverify.web.model.requestbody.VulnVerifyCodeReqBody;
import com.vulnverify.web.model.requestbody.VulnVerifyReqBody;
import com.vulnverify.web.model.view.VulnVerifyView;
import com.vulnverify.web.service.VulnVerifyService;
/**
 * 用户接口实现
 * @author zhangdj
 * @date 2018年4月24日  
 *
 */
@Service
public class VulnVerifyServiceImpl extends GenericServiceImpl<TVulnVerifyLib, Integer> implements VulnVerifyService{
	@Resource
	private TVulnVerifyLibMapper   vulnVerifyLibMapper ;
	@Resource
	private TPatchSolutionMapper   patchSolutionMapper ;
	@Resource
	private TVulnVerifyCodeMapper  vulnVerifyCodeMapper ;
	@Resource
	private TVulnVerifyRecordMapper vulnVerifyRecordMapper;
	


	public void getList(Page<VulnVerifyView> page, VulnVerifyReqBody queryInfo) {
		List<VulnVerifyView> list = vulnVerifyLibMapper.getList(page,queryInfo);
		
	}
	
	
	//添加补丁信息
	public void addPatch(List<MultipartFile> files,TPatchSolution patch)  throws Exception{
		//String uuid = UUID.randomUUID().toString();
    	String patchFileUploadPath = ApplicationUtils.getProperty("patchFileUploadPath");
		int length = files.size();
		for(int i=0;i<length;i++){
			MultipartFile uploadFile= files.get(i);
			String originalFilename = uploadFile.getOriginalFilename();//文件名
			InputStream inputStream = uploadFile.getInputStream();
			long fileSize = uploadFile.getSize();
//			String type = uploadFile.getContentType();//文件类型
			//String fileId = GeneralMongoDbUtil.uploadFileToGridFS(originalFilename,inputStream,Constant.MONGODB_SF,true);
		    File file = new File(patchFileUploadPath);
		    if(!file.exists()){
		    	file.mkdirs();
		    }
	    	file = new File(patchFileUploadPath, originalFilename);
	    	uploadFile.transferTo(file);
			//保存文件表数据

			patch.setFileName(originalFilename); //存储文件名
			patch.setPatchFileUrl(patchFileUploadPath); //文件id
			patch.setPatchFileSize(fileSize); //补丁大小
			
			patchSolutionMapper.insert(patch);
			
			TVulnVerifyLib record = vulnVerifyLibMapper.selectByPrimaryKey(new Integer(patch.getVulnId()));
			record.setPatchstatus(Constant.PATCH_UPLOAD_STATE_ABLE);//已经上传补丁
			record.setUpdateTime(new Date());
			vulnVerifyLibMapper.updateByPrimaryKey(record);

		}
		
	}
	
	public void addVerifyCode(List<MultipartFile> files,TVulnVerifyCode verifyCode) throws Exception {
		String verifyCodeUploadPath = ApplicationUtils.getProperty("verifyCodeUploadPath");
		int length = files.size();
		for(int i=0;i<length;i++){
			MultipartFile uploadFile= files.get(i);
			String originalFilename = uploadFile.getOriginalFilename();//文件名
			InputStream inputStream = uploadFile.getInputStream();
			long fileSize = uploadFile.getSize();
//			String type = uploadFile.getContentType();//文件类型
			//String fileId = GeneralMongoDbUtil.uploadFileToGridFS(originalFilename,inputStream,Constant.MONGODB_SF,true);
		    File file = new File(verifyCodeUploadPath);
		    if(!file.exists()){
		    	file.mkdirs();
		    }
	    	file = new File(verifyCodeUploadPath, originalFilename);
	    	uploadFile.transferTo(file);
			//保存文件表数据

	    	verifyCode.setCodeFileName(originalFilename); //存储文件名
	    	verifyCode.setCodeFileUrl(verifyCodeUploadPath);

			
			vulnVerifyCodeMapper.insert(verifyCode);
			
			TVulnVerifyLib record = vulnVerifyLibMapper.selectByPrimaryKey(new Integer(verifyCode.getVulnId()));
			record.setVerifycodestatus(Constant.VERIFYCODE_UPLOAD_STATE_ABLE);//已经上传验证代码
			record.setUpdateTime(new Date());
			vulnVerifyLibMapper.updateByPrimaryKey(record);

		}
		
		 
	}

	
	public List<TPatchSolution> queryPatchInfo(PatchSolutionReqBody requestBody) throws Exception{
		return patchSolutionMapper.selectByVulnId(requestBody);
	}
	
	public List<TVulnVerifyCode> queryVerifyCode(VulnVerifyCodeReqBody requestBody) throws Exception{
		return vulnVerifyCodeMapper.selectByVulnId(requestBody);
	}
	//保存漏洞验证记录
	public void saveVulnVerifyRecord(TVulnVerifyRecord record) throws Exception{
		vulnVerifyRecordMapper.insert(record);
	}

	
	public GenericDao<TVulnVerifyLib, Integer>  getDao() {

		return vulnVerifyLibMapper;
	}



}
