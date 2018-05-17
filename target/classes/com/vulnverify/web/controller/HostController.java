package com.vulnverify.web.controller;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;


import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vulnverify.core.entity.PageData;
import com.vulnverify.core.entity.PageQuery;
import com.vulnverify.core.entity.SimpleException;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.core.utils.ApplicationUtils;
import com.vulnverify.core.utils.CxfInvokeUtil;
import com.vulnverify.web.constant.Constant;
import com.vulnverify.web.model.THost;
import com.vulnverify.web.model.requestbody.IdReqBody;
import com.vulnverify.web.model.requestbody.HostListReqBody;
import com.vulnverify.web.model.view.HostView;
import com.vulnverify.web.service.HostService;

import tns.Application;
import java.math.BigDecimal;





@Controller
@RequestMapping(value="/host")
public class HostController extends BaseController{
	private static Logger logger=LoggerFactory.getLogger(HostController.class);
	@Resource
	private HostService hostService;
	
	@RequestMapping(value="host")
	@ResponseBody
	public Object host(){
		return generateResultData("sucess");
	}
	
	/**
	 * 查询	
	 * @param pageQuery
	 * @return
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(@RequestBody PageQuery<HostListReqBody> pageQuery) {
		try {
			// 请求云平台接口
	        Application port= CxfInvokeUtil.getCloudServiceProxy();
	        String apiRespose = port.getPhysicalall();
	        ObjectMapper om = new ObjectMapper();
	        JsonNode node = om.readTree(apiRespose);
	     
	        String flag=node.findValue("result").asText();
	        if("true".equals(flag)) {
	        	JsonNode jsonNode=node.findValue("data");
	        	Iterator<JsonNode> elements = jsonNode.elements(); 
	        	 while(elements.hasNext()){    
	        	     JsonNode hostNode = elements.next();    
	        	     String hostMachineUuid=hostNode.findValue("uid").asText();
	        	     System.out.println(hostMachineUuid);
					if (hostService.selectByUuid(hostMachineUuid)==null) {
	        	    	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	        	    	THost host=new THost();
	        	    	host.setHostMachineUuid(hostNode.findValue("uid").asText());
	        	    	host.setHostMachineIp(hostNode.findValue("ip").asText());       	    	
	        	    
	        	    	host.setHostName(hostNode.findValue("name").asText());
	        	    	String status=hostNode.findValue("physical_state").asText();
	        	    	if(status.equals("running")) {
	        	    		host.setStatus("1");
	        	    	}else {
	        	    		host.setStatus("2");
	        	    	}
	        	    	host.setCpuCoreNum(hostNode.findValue("cpu").asInt());
	        	    	host.setRamSize(hostNode.findValue("ram").asInt());
	        	    	host.setDiskSize(hostNode.findValue("disk_size").asInt());
	        	    	
	        	    	BigDecimal currentDiskSize=new BigDecimal(hostNode.findValue("current_disk_size").asText());
	        	    	host.setCurrentDiskSize(currentDiskSize);
	        	    	BigDecimal ramTotalUsage=new BigDecimal(hostNode.findValue("ram_total_usage").asText());
	        	    	host.setRamTotalUsage(ramTotalUsage);        	    	
	        	    	BigDecimal currentCpu=new BigDecimal(hostNode.findValue("current_cpu").asText());
	        	    	host.setCurrentCpu(currentCpu);
	        	    	host.setCreateTime(format.parse(hostNode.findValue("created_at").asText()));
	        	    	//host.setCreateUser(hostNode.findValue("uid").asText());        	    	
	        	    	host.setUpdateTime(format.parse(hostNode.findValue("updated_at").asText()));
	        	    	//host.setUpdateUser(hostNode.findValue("uid").asText());
	        	    	hostService.insert(host);
	        	    }
	        	 }  	
	        }
			Page<HostView> page = generatePage(pageQuery);
			hostService.getList(page, pageQuery.getQueryInfo());
			PageData<HostView> generatePageData = generatePageData(page);
			return generatePageData;
		}
		catch (Exception e) {
			e.printStackTrace();
			return generateFailedData();
		}		
	}
	/**
	 * 重启	
	 * @param pageQuery
	 * @return
	 */
	@RequestMapping(value = "/restart")
	@ResponseBody
	public Object open(@RequestBody IdReqBody requestBody) {
		try{
			THost hostInfo = hostService.selectById(Integer.parseInt(requestBody.getId()));
	    	if(hostInfo == null){
	    		throw new SimpleException(Constant.EXCEPTION_S0010008,
	    				ApplicationUtils.getMessage(Constant.EXCEPTION_S0010008));
	    	}	
	    	hostInfo.setStatus("1");
			hostService.update(hostInfo);
			return generateResultData();
		}catch (Exception e) {
	    	throw e;
		}
	}	
	/**
	 * 关机	
	 * @param pageQuery
	 * @return
	 */
	@RequestMapping(value = "/stop")
	@ResponseBody
	public Object close(@RequestBody IdReqBody requestBody) {
		try{
			THost hostInfo = hostService.selectById(Integer.parseInt(requestBody.getId()));
	    	if(hostInfo == null){
	    		throw new SimpleException(Constant.EXCEPTION_S0010008,
	    				ApplicationUtils.getMessage(Constant.EXCEPTION_S0010008));
	    	}	
	    	hostInfo.setStatus("2");
			hostService.update(hostInfo);
			return generateResultData();
		}catch (Exception e) {
        	throw e;
		}
	}	

}
