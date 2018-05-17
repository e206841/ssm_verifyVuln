package com.vulnverify.web.controller;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vulnverify.core.entity.PageQuery;
import com.vulnverify.web.model.TPatchSolution;
import com.vulnverify.web.model.TVulnVerifyCode;
import com.vulnverify.web.model.requestbody.PatchSolutionReqBody;
import com.vulnverify.web.model.requestbody.VulnVerifyCodeReqBody;
import com.vulnverify.web.model.requestbody.VulnVerifyReqBody;
public class VulnVerifyControllerTest extends TestBase{
private final static Logger logger = LoggerFactory.getLogger(VulnVerifyControllerTest.class);
	
	/**
	 * 查询列表
	 * @throws Exception
	 */
	@Test
	public void list()throws Exception{
		logger.info("漏洞验证查询列表单元测试");
		PageQuery<VulnVerifyReqBody> body = getBody();
		String result = perform("/vulnVerify/list",body);
		logger.info("result:"+result);
	}

	private PageQuery<VulnVerifyReqBody> getBody() {
		PageQuery<VulnVerifyReqBody> body=new PageQuery<VulnVerifyReqBody>();
		VulnVerifyReqBody req=new VulnVerifyReqBody();
		body.setQueryInfo(req);
		return body;
	}
	
	
	public void addPatch()throws Exception{
		logger.info("添加补丁功能单元测试");
		TPatchSolution  body = getPatchBody();
		String result = perform("/vulnVerify/addPatch",body);
		logger.info("result:"+result);
	}

	private TPatchSolution getPatchBody() {
		TPatchSolution body=new TPatchSolution();
		body.setPatchId(2);
		body.setPatchNo("2");
		body.setPatchName("补丁2");
		return body;
	}
	
	/**
	 * 查询补丁信息
	 * @throws Exception
	 */
	
	public void queryPatchInfo()throws Exception{
		logger.info("查询查询补丁信息单元测试");
		//PageQuery<VulnVerifyReqBody> body = getBody();
		PatchSolutionReqBody body = new PatchSolutionReqBody();
		body.setVulnId("1");
		String result = perform("/vulnVerify/queryPatchInfo",body);
		logger.info("result:"+result);
	}


	public void queryVerifyCode()throws Exception{
		logger.info("查询代码验证信息单元测试");
		VulnVerifyCodeReqBody body = new VulnVerifyCodeReqBody();
		body.setVulnId("1");
		String result = perform("/vulnVerify/queryVerifyCode",body);
		logger.info("result:"+result);
	}
	
	
	
	public void addVerifyCode()throws Exception{
		logger.info("添加补丁功能单元测试");
		TVulnVerifyCode  body = getVerifyCode();
		String result = perform("/vulnVerify/addVerifyCode",body);
		logger.info("result:"+result);
	}

	private TVulnVerifyCode getVerifyCode() {
		TVulnVerifyCode body=new TVulnVerifyCode();
		body.setVulnId(1);
		body.setCodeFileId(1);
		body.setCodeFileName("code1");
		return body;
	}
	
	
}
