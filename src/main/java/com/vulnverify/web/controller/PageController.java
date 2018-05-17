package com.vulnverify.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vulnverify.core.entity.SimpleException;
import com.vulnverify.core.entity.SimpleResult;


/**
 * 视图控制器
 * @author linan
 * @date 2018年5月14日  
 *
 */
@Controller
@RequestMapping("/page")
public class PageController {

    /**
     * 登录页
     */
    @RequestMapping("/login")
    public String login() {
        return "redirect:/static/login/login.html";
    }

    /**
     * 404页
     */
    @RequestMapping("/404")
    public String error404() {
        return "404";
    }

    /**
     * 401页
     */
    @RequestMapping("/401")
    public String error401() {
        return "401";
    }

    /**
     * 500页
     */
    @RequestMapping("/500")
    public String error500() {
        return "500";
    }
    
    /**
     * 400页
     */
    @RequestMapping("/400")
    public String error400() {
        return "400";
    }
    
    @RequestMapping("/exception")
    @ResponseBody
    public Object exception(HttpServletRequest request) {
    	SimpleResult sr = new SimpleResult();
    	Exception ex = (Exception)request.getAttribute("exception");
    	if(ex instanceof SimpleException){
    		SimpleException se = (SimpleException)ex;
    		sr.setCode(se.getErrorCode());
    		sr.setMsg(se.getErrorMsg());
    	}else{
    		sr.setCode("001");
    		sr.setMsg("program exception:"+ex.getMessage());
    	}
    	ObjectMapper om = new ObjectMapper();
    	try {
			om.writerWithDefaultPrettyPrinter().writeValueAsString(sr);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return sr;
    }

}