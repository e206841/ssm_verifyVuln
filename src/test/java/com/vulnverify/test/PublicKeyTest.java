package com.vulnverify.test;

import javax.security.auth.Subject;

import org.apache.shiro.SecurityUtils;
import org.junit.Test;

import com.vulnverify.web.controller.TestBase;
import com.vulnverify.web.model.TUser;
import com.vulnverify.web.security.PermissionSign;

public class PublicKeyTest extends TestBase{
	@Test
	public void test() throws Exception{
		login("vulnadmin", "123456");
		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
		TUser user=(TUser) subject.getSession().getAttribute("userInfo");
		System.out.println("登陆："+user.getUserName());
		logout();
		System.out.println("登出");
	}

}
