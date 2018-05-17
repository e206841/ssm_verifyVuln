package com.vulnverify.web.controller;

import javax.security.auth.Subject;

import org.apache.shiro.SecurityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vulnverify.core.entity.PageQuery;
import com.vulnverify.web.model.TUser;
import com.vulnverify.web.model.requestbody.UserListReqBody;

public class UserControllerTest extends TestBase{
private final static Logger logger = LoggerFactory.getLogger(UserControllerTest.class);
	
	/**
	 * 查询列表
	 * @throws Exception
	 */
	@Test
	public void list()throws Exception{
		logger.info("用户查询列表单元测试");
		login("zhangsan", "123456");
		PageQuery<UserListReqBody> body = getBody();
		String result = perform("/user/list",body);
		logger.info("result:"+result);
//		logout();
	}

	private PageQuery<UserListReqBody> getBody() {
		PageQuery<UserListReqBody> body=new PageQuery<UserListReqBody>();
		UserListReqBody req=new UserListReqBody();
		body.setQueryInfo(req);
		return body;
	}
	
	@Test
	public void userRights()throws Exception{
		logger.info("获取用户权限");
		login("zhangsan", "123456");
		TUser user=(TUser) SecurityUtils.getSubject().getSession().getAttribute("userInfo");
		System.out.println(user.getUserName());
		String result = perform("/user/getLoginUserRights",null);
		logger.info("result:"+result);
//		logout();
	}
}
