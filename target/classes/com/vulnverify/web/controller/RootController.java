package com.vulnverify.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 
 * @author linan
 *
 */
@Controller
@RequestMapping(value="/root")
public class RootController {
	private Logger logger = Logger.getLogger(RootController.class);
	
	/**
	 * 首页
	 * @param requestBody	请求体
	 * @return	返回常用数据
	 * @throws Exception	异常
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String root(HttpServletRequest request) throws Exception{
		return "redirect:/static/index.html";
	}
}
