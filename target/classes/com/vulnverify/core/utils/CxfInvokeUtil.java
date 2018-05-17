package com.vulnverify.core.utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import tns.Application;
import tns.Application_Service;

/**
 * 
 * 使用cxf 调用webservice 接口
 * 
 * @author linan
 * 
 */
public class CxfInvokeUtil {

	static Logger logger = Logger.getLogger(CxfInvokeUtil.class);
	private static String wsdlUrl="";
	
	static{
		String filePath = null;
		try {
			filePath = ApplicationUtils
					.getWebFileAbsoluteClassPath("application.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	Properties pro = FileUtil.loadProperties(filePath);
    	wsdlUrl = pro.getProperty("cxf.url");
    	logger.info("初始化cxf调用webservice地址为:"+wsdlUrl);
	}
	/**
	 * 
	 * 调用webservice 接口
	 * 
	 * @param method
	 *            调用方法名
	 * 
	 * @param params
	 *            接口传入参数
	 * 
	 * @return
	 * 
	 */
	public static synchronized Object[] invoke(String method,Object params) {
		Object[] objects = null;
		String paramsStr = null;
		try {
			ObjectMapper om = new ObjectMapper();
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory
					.newInstance();
			org.apache.cxf.endpoint.Client client = dcf.createClient(wsdlUrl);
			//如果返回的address不是远程服务地址，重新制定地址
			client.getEndpoint().getEndpointInfo().setAddress(wsdlUrl);
			if (StringUtils.isEmpty(method)) {

				logger.error("cxf 调用webservice 执行方法名缺失：method 未传入");
				return objects;
			}


			paramsStr = om.writeValueAsString(params);
			logger.info("cxf 调用webservice method:"+method+",参数:" + paramsStr);

			HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();    // 策略
			httpClientPolicy.setConnectionTimeout( 36000 );    //连接超时 
			httpClientPolicy.setAllowChunking( false );   
			httpClientPolicy.setReceiveTimeout( 10000 );       //接收超时
			HTTPConduit http = (HTTPConduit) client.getConduit();  
			http.setClient(httpClientPolicy);	
			    
			    
			objects = client.invoke(method, paramsStr);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("cxf 调用webservice 执行错误：", e);

		}

		return objects;
	}
	/**
	 * 获取云平台WebServcie代理接口
	 */
	public static Application getCloudServiceProxy() {
        Application_Service ss = new Application_Service();
        ss.addPort(Application_Service.SERVICE, "", wsdlUrl);
        Application port = ss.getApplication();
        return port;
	}

	/**
	 * 调用指定的云平台接口，按指定的类型返回反序列化后的java对象。
	 * 
	 * @param apiName 云平台接口在本地代理类“tns.Application”中对应的方法名
	 * @param args apiName参数指定的“tns.Application”中方法的参数数组
	 * @param data 将云平台接口返回结果中的“data”部分数据反序列化为java对象，此参数为反序列化目标类型的任意实例
	 * @return 返回云平台接口返回的数据中“data”部分的反序列化java对象，其类型为参数data的类型。如果调用接口失败或者返回数据验证失败则返回null。
	 * @throws IOException
	 * @throws JsonProcessingException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 */
	public static <T> T callCloudServcie(String apiName, Object[] args, T data)
	        throws IOException, JsonProcessingException, JsonParseException, JsonMappingException{
		
		Method method = null;
		for(Method m : tns.Application.class.getMethods()) {
			if(m.getName().equals(apiName)) {
				method = m;
				break;
			}
		}
		if(method == null) {
			logger.error("调用云平台接口" + apiName + "失败，不存在此接口的本地代理方法。/n参数：" + Arrays.deepToString(args));
			return null;
		}
		
		Application port= CxfInvokeUtil.getCloudServiceProxy();
		Object apiRespose;

		try {
			apiRespose = method.invoke(port, args);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			logger.error("调用云平台接口" + apiName + "失败，" + e.getMessage() + "/n参数：" + Arrays.deepToString(args));
			e.printStackTrace();
			return null;
		}
		
		com.fasterxml.jackson.databind.ObjectMapper om = new com.fasterxml.jackson.databind.ObjectMapper();
		JsonNode node = om.readTree(apiRespose.toString());
        Map<String, Object> map = om.readValue(node.toString(), new TypeReference<Map<String,Object>>(){});
        Object result = map.get("result");
        Object error = map.get("error");
        Object _data =  map.get("data");
        if(result == null 
    		|| result.toString() != "true" 
    		|| _data == null
    		|| _data.toString().length() == 0) 
        {
        	logger.error("调用云平台接口" + apiName + "返回错误，error：" + error + "/n参数：" + Arrays.deepToString(args));
        	return null;
        }
        
        if(!_data.getClass().equals(data.getClass()))
        {
			logger.error("调用云平台接口" + apiName + "返回数据格式不正确，data：" + _data + "/n参数：" + Arrays.deepToString(args));
			return null;
		}
        logger.debug("调用云平台接口" + apiName + "成功。返回数据：" + _data + "/n参数：" + Arrays.deepToString(args));
        return om.convertValue(_data, new TypeReference<T>(){});
	}
	public static void main(String[] args) {
//		CxfInvokeUtil.invoke("get_images", "");
	}
}