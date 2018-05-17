package com.vulnverify.web.service;



import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vulnverify.core.generic.GenericService;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.web.model.TPatchSolution;
import com.vulnverify.web.model.TVulnVerifyCode;
import com.vulnverify.web.model.TVulnVerifyLib;
import com.vulnverify.web.model.TVulnVerifyRecord;
import com.vulnverify.web.model.requestbody.PatchSolutionReqBody;
import com.vulnverify.web.model.requestbody.VulnVerifyCodeReqBody;
import com.vulnverify.web.model.requestbody.VulnVerifyReqBody;
import com.vulnverify.web.model.view.VulnVerifyView;


/**
 * 用户接口
 * @author zhangdj
 * @date 2018年4月24日  
 *
 */
public interface VulnVerifyService extends GenericService<TVulnVerifyLib, Integer>{
	/**
	 * 分页查询
	 * @param page
	 * @param queryInfo
	 */
	void getList(Page<VulnVerifyView> page, VulnVerifyReqBody queryInfo);
	
	public void addPatch(List<MultipartFile> files,TPatchSolution patch)  throws Exception;
	
	public void addVerifyCode(List<MultipartFile> files,TVulnVerifyCode verifyCode)  throws Exception;
	
	public List<TPatchSolution> queryPatchInfo(PatchSolutionReqBody requestBody) throws Exception;;
	
	public List<TVulnVerifyCode> queryVerifyCode(VulnVerifyCodeReqBody requestBody) throws Exception;
	
	public void saveVulnVerifyRecord(TVulnVerifyRecord record) throws Exception;

}
