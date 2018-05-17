package com.vulnverify.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import com.vulnverify.core.utils.PasswordHash;
import com.vulnverify.web.model.requestbody.LoginReqBody;



@WebAppConfiguration(value = "src/main/webapp")
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath*:applicationContext.xml",
									"classpath*:applicationContext-shiro.xml",
									"classpath*:spring-mvc.xml"})
public abstract class TestBase extends AbstractJUnit4SpringContextTests{
	@Autowired
	protected WebApplicationContext wac;
	protected MockMvc mockMvc;
	protected String userKey="12345678";
	@Autowired
	private DefaultSecurityManager securityManager;
	@Before
    public void setup() throws Exception {

        this.mockMvc = webAppContextSetup(this.wac).build();
        SecurityUtils.setSecurityManager(securityManager);
        SecurityUtils.getSubject().getSession();
        
    }
	 public String perform(String uri,Object requestBody) throws Exception{
	    	ObjectMapper om = new ObjectMapper();
	    	String jsonStr = null;
	    	if(requestBody instanceof String){
	    		jsonStr = (String)requestBody;
	    	}else{
	    		jsonStr = om.writeValueAsString(requestBody);
	    	}
	    	logger.info("requestbody:"+jsonStr);
			String simpleSign = PasswordHash.getHmacSHA1(userKey, jsonStr);
			MvcResult mvcResult = this.mockMvc.perform(  
	            post(uri, "json").characterEncoding("UTF-8")  
	                .contentType(MediaType.APPLICATION_JSON)
	                .header("simpleSign", simpleSign)
	                .content(jsonStr.getBytes("UTF-8")))
	            .andReturn();
			MockHttpServletResponse response = mvcResult.getResponse();
			response.setCharacterEncoding("UTF-8");
			String result = response.getContentAsString();
	    	return result;
	    }
	 public String login(String loginName,String password)throws Exception{
	    	
	    	perform("/verificationCode","{}");
	    	
	    	String  verificationCode = (String)SecurityUtils.getSubject().getSession(false)
	    		.getAttribute("verificationCode");
	    	
	    	LoginReqBody lrb = new LoginReqBody();
			lrb.setUserAccount(loginName);
			lrb.setPassword(password);
			lrb.setUserKey(userKey);
			lrb.setVerificationCode(verificationCode);
			
			return perform("/user/login",lrb);
			
	    }
	    
	    public void logout(){
	    	SecurityUtils.getSubject().logout();
	    }
}
