package com.vulnverify.web.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vulnverify.core.utils.ApplicationUtils;
import com.vulnverify.core.utils.FileUtil;

/**
 * 获取公共密钥
 * @author linan
 **/
@Controller
public class PublicKeyController extends BaseController{
	
    /**
     * 
     * 获取公共密钥
     * 
     * @param request
     * @return
     * @throws IOException 
     */
    @RequestMapping("publicKey")
    @ResponseBody
    public Object getPublicKey() throws IOException {
    	String filePath = ApplicationUtils
    			.getWebFileAbsoluteClassPath("publicKey");
		byte[] a = FileUtil.getContent(filePath);
		String publicKey = new String(a);
		return generateResultData(publicKey);
    }

}