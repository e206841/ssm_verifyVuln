package com.vulnverify.web.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tns.Application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vulnverify.core.utils.CxfInvokeUtil;

@Controller
@RequestMapping(value="/test")
public class TestController extends BaseController{
	
@RequestMapping(value="test")
@ResponseBody
public Object test() throws JsonProcessingException, IOException{
	// 请求云平台接口
    Application port= CxfInvokeUtil.getCloudServiceProxy();
    String apiRespose = port.getImages(null);
    ObjectMapper om = new ObjectMapper();
    JsonNode node = om.readTree(apiRespose);
    Map<String, Object> map = om.readValue(node.toString(), new TypeReference<Map<String,Object>>(){});
	
	
	return generateResultData("sucess");
}

}
