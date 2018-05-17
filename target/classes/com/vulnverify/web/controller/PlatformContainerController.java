package com.vulnverify.web.controller;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vulnverify.core.entity.PageData;
import com.vulnverify.core.entity.PageQuery;
import com.vulnverify.core.entity.Result;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.core.utils.CxfInvokeUtil;
import com.vulnverify.web.model.THost;
import com.vulnverify.web.model.TImage;
import com.vulnverify.web.model.TPlatformContainer;
import com.vulnverify.web.model.requestbody.PlatformContainerReqBody;
import com.vulnverify.web.model.view.PlatformContainerView;
import com.vulnverify.web.service.HostService;
import com.vulnverify.web.service.ImageService;
import com.vulnverify.web.service.PlatformContainerService;

import tns.Application;

/**
 * 用户控制类
 * @author zhangdj
 * @date 2018年4月23日  
 *
 */
@Controller
@RequestMapping(value="/container")
public class PlatformContainerController extends BaseController{
	
		private static Logger logger=LoggerFactory.getLogger(PlatformContainerController.class);
		@Resource
		private PlatformContainerService  platformContainerService;
		@Resource
		private HostService  hostService;
		@Resource
		private ImageService  imageService;
		/**
		 * 查询	
		 * @param pageQuery
		 * @return
		 */
		@RequestMapping(value = "/list")
		@ResponseBody
		public Object list(@RequestBody PageQuery<PlatformContainerReqBody> pageQuery) throws Exception {
			logger.info("获取容器列表");
			// 请求云平台接口
	        Application port= CxfInvokeUtil.getCloudServiceProxy();
	        String apiRespose = port.
	        		getContainers(null, pageQuery.getQueryInfo().getImageName(), null, null);
	        ObjectMapper om = new ObjectMapper();
	        JsonNode node = om.readTree(apiRespose);
	     
	        String flag=node.findValue("result").asText();
	        if("true".equals(flag)) {
	        	JsonNode jsonNode=node.findValue("data");
	        	Iterator<JsonNode> elements = jsonNode.elements(); 
	        	 while(elements.hasNext()){    
	        	     JsonNode containerNode = elements.next();    
	        	     String containerUuid=containerNode.findValue("container_uuid").asText();
	        	 	TPlatformContainer platformContainer=new TPlatformContainer();
	        	 	platformContainer.setContainerUuid(containerUuid);
	        	 	TPlatformContainer local=platformContainerService.selectMatch(platformContainer);
	        	    if( local==null) { //如果本地数据库没有则增加
	        	    	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	        	    
	        	    	platformContainer.setContainerName(containerNode.findValue("name").asText());
	        	    	
	        	    	platformContainer.setCpuCoreNum(containerNode.findValue("cpu").asInt());
	        	    	platformContainer.setCreateTime(format.parse(containerNode.findValue("created_at").asText()));
	        	    	platformContainer.setCreateUser(containerNode.findValue("uid").asText());
	        	    	platformContainer.setDiscription(containerNode.findValue("description").asText());
	        	    	platformContainer.setDiskSize(containerNode.findValue("root_disk_size").asInt());
	        	    	platformContainer.setRamSize(containerNode.findValue("ram").asInt());
	        	    	platformContainer.setStatus(containerNode.findValue("state").asText());
	        	    	platformContainer.setUpdateTime(format.parse(containerNode.findValue("updated_at").asText()));
	        	    	platformContainer.setUpdateUser(containerNode.findValue("uid").asText());
	        	    	THost host=new THost();
	        	    	host.setHostMachineUuid(containerNode.findValue("host").asText());
	        	    	host.setHostName(containerNode.findValue("hostname").asText());
	        	    	host=hostService.selectMatch(host);
	        	    	platformContainer.setHostname(containerNode.findValue("hostname").asText());
	        	    	if(host!=null) {
	        	    		platformContainer.setHostmachineId(host.getHostMachineId());   //取host外键
	        	    	}
	        	    	TImage image=new TImage();
	        	    	image.setImageUuid(containerNode.findValue("image").asText());  //取image外键
	        	    	image=imageService.selectMatch(image);
	        	    	if(image!=null) {
	        	    		platformContainer.setImageName(image.getImageName());
	        	    		platformContainer.setImageId(image.getImageId());
	        	    	}	        	    	
	        	    	
	        	    	//platformContainer.setHostmachineId();
	        	    	//platformContainer.setHostname(containerNode.findValue("hostname").asText());

	        	    	//platformContainer.setImageId(containerNode.findValue("uid").asText());
	        	    	//platformContainer.setImageName(containerNode.findValue("image").asText());
	        	    
	        	    	platformContainerService.insert(platformContainer);
	        	    }else {                                //如果本地数据库有则更新
	        	    	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		        	    
	        	    	platformContainer.setContainerName(containerNode.findValue("name").asText());
	        	    	
	        	    	platformContainer.setCpuCoreNum(containerNode.findValue("cpu").asInt());
	        	    	platformContainer.setCreateTime(format.parse(containerNode.findValue("created_at").asText()));
	        	    	platformContainer.setCreateUser(containerNode.findValue("uid").asText());
	        	    	platformContainer.setDiscription(containerNode.findValue("description").asText());
	        	    	platformContainer.setDiskSize(containerNode.findValue("root_disk_size").asInt());
	        	    	platformContainer.setRamSize(containerNode.findValue("ram").asInt());
	        	    	platformContainer.setStatus(containerNode.findValue("state").asText());
	        	    	platformContainer.setUpdateTime(format.parse(containerNode.findValue("updated_at").asText()));
	        	    	platformContainer.setUpdateUser(containerNode.findValue("uid").asText());
	        	    	THost host=new THost();
	        	    	host.setHostMachineUuid(containerNode.findValue("host").asText());
	        	    	host.setHostName(containerNode.findValue("hostname").asText());
	        	    	host=hostService.selectMatch(host);
	        	    	platformContainer.setHostname(containerNode.findValue("hostname").asText());
	        	    	if(host!=null) {
	        	    		platformContainer.setHostmachineId(host.getHostMachineId());//取host外键
	        	    	}
	        	    	TImage image=new TImage();
	        	    	image.setImageUuid(containerNode.findValue("image").asText());
	        	    	image=imageService.selectMatch(image);
	        	    	if(image!=null) {
	        	    		platformContainer.setImageName(image.getImageName());
	        	    		platformContainer.setImageId(image.getImageId()); //取image外键
	        	    	}
        	    		platformContainer.setContainerId(local.getContainerId());
	        	    	if(platformContainerService.selectMatch(platformContainer)==null) {  //比对云平台和本地是否同步

	        	    		platformContainerService.update(platformContainer);
	        	    	}
	        	    	
	        	    }
	        	 }  	
	        }
			Page<PlatformContainerView> page = generatePage(pageQuery);
			platformContainerService.getList(page, pageQuery.getQueryInfo());
			PageData<PlatformContainerView> generatePageData = generatePageData(page);
			return generatePageData;
		}
		/**
		 * 增加	
		 * @param pageQuery
		 * @return
		 */		
		@RequestMapping(value = "/add")
		@ResponseBody		
		public Object add(@RequestBody  TPlatformContainer vo) throws Exception{
			logger.info("增加容器");
			System.out.println(vo);
			// 请求云平台接口
	        Application port= CxfInvokeUtil.getCloudServiceProxy();
	        TImage image=imageService.selectById(vo.getImageId());
	        String apiRespose = port.createContainer(vo.getContainerName(), vo.getDiscription(), image.getImageUuid(), new BigInteger(vo.getCpuCoreNum().toString()), new BigInteger(vo.getRamSize().toString()), new BigInteger(vo.getDiskSize().toString()), null, null, "auto", null, null, null, false);
	        ObjectMapper om = new ObjectMapper();
	        JsonNode node = om.readTree(apiRespose);
	        Map<String, Object> map = om.readValue(node.toString(), new TypeReference<Map<String,Object>>(){});
            if((Boolean)map.get("result")) {
	        	String containerUuid=node.findValue("data").findValue("container_uuid").asText();
	        	vo.setContainerUuid(containerUuid);
	        	vo.setStatus("closed");
	            vo.setImageName(image.getImageName());   
    			int flag=platformContainerService.insert(vo);
    			return flag==1?generateResultData():generateFailedData(null,"本地容器创建失败");            	
            }
            return generateFailedData(null,"云平台容器创建失败"); 
		}
		/**
		 * 全部镜像
		 * 
		 * @param request 请求体
		 * @return 返回常用数据
		 * @throws Exception 异常
		 */  
		@ResponseBody
		@RequestMapping(value = "add/imageList", method = RequestMethod.POST)
		public Object listAll() throws Exception {
			return super.vulnResultData(imageService.selectAll(), "succeed !!!");
		}
       /**
        * 开启并连接虚拟机
        */
		@RequestMapping(value = "/vm/getConnectionInfo")
		@ResponseBody
		public Object getConnectionInfo(@RequestBody PlatformContainerView vo) throws Exception{
			logger.info("连接虚拟机");
	    	PlatformContainerView platformContainerView=new PlatformContainerView();
	    	Result<PlatformContainerView> rs=null;
			// 请求云平台接口
	        Application port= CxfInvokeUtil.getCloudServiceProxy();
	        TPlatformContainer po= platformContainerService.selectById(vo.getContainerId());
	        String apiRespose = port.getContainerDetails(po.getContainerUuid());
	        JsonNode node = om.readTree(apiRespose);
	        JsonNode dataNode= node.findValue("data");
	        String statusResponse=null;
	        if("closed".equals(dataNode.findValue("state").asText())) {
	        	statusResponse = port.startContainer(po.getContainerUuid());
	        	rs=generateResultData(platformContainerView);
	        	platformContainerView.setStatus(dataNode.findValue("state").asText());
	        	rs.setMsg("容器未开启正在开启请稍后");	
	        	rs.setCode("000");
	        }else if("running".equals(dataNode.findValue("state").asText())){
	        	platformContainerView.setIp(dataNode.findValue("run_at_ip").asText());
	        	platformContainerView.setVncPort(dataNode.findValue("vnc_port").asText());
	        	platformContainerView.setNoVncPort(dataNode.findValue("vnc_port").asText());
	        	platformContainerView.setVncPassword(dataNode.findValue("vnc_password").asText());
	        	platformContainerView.setPassWord(dataNode.findValue("vnc_password").asText());      
	        	platformContainerView.setStatus(dataNode.findValue("state").asText());
	        	rs=generateResultData(platformContainerView);
	        	rs.setMsg("容器已开启");	        	
	        }else {
	        	platformContainerView.setStatus(dataNode.findValue("state").asText());
	        	rs=generateFailedData(platformContainerView,"容器开启失败");
	        }
	        return rs ;
		}
	       /**
	        * 虚拟机关闭
	        */
			@RequestMapping(value = "/vm/stopVm")
			@ResponseBody
			public Object stopVm(@RequestBody PlatformContainerView vo) throws Exception{
				logger.info("关闭虚拟机");
		    	PlatformContainerView platformContainerView=new PlatformContainerView();
		    	Result<PlatformContainerView> rs=null;
				// 请求云平台接口
		        Application port= CxfInvokeUtil.getCloudServiceProxy();
		        TPlatformContainer po= platformContainerService.selectById(vo.getContainerId());
		        String apiRespose = port.getContainerDetails(po.getContainerUuid());
		        JsonNode node = om.readTree(apiRespose);
		        JsonNode dataNode= node.findValue("data");
		        String statusResponse=null;
		        if("running".equals(dataNode.findValue("state").asText())) {
		        	statusResponse = port.stopContainer(po.getContainerUuid());
		        	rs=generateResultData(null);
		        	rs.setMsg("容器关闭成功");	
		        } else  if("closed".equals(dataNode.findValue("state").asText())) {
		        	rs=generateResultData(null);
		        	rs.setMsg("容器已关闭不需要关闭");	
		        }else {
		        	rs=generateFailedData(null,"容器关闭失败");
		        }
		        return rs ;
			}
}