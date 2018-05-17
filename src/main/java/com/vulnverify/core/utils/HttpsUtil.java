package com.vulnverify.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.util.Properties;

import javax.net.ssl.SSLContext;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * https工具类
 * @author LiWenbin
 */
public class HttpsUtil {
	
	private static String interfaceServerIp;
	private static Integer interfaceServerPort;
	private static String keystorePassword;
	private static String truststorePassword;
	
	static{
		String filePath = null;
		try {
			filePath = ApplicationUtils
					.getWebFileAbsoluteClassPath("application.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	Properties pro = FileUtil.loadProperties(filePath);
    	interfaceServerIp = pro.getProperty("interface.server.ip");
    	interfaceServerPort = Integer.valueOf(pro.getProperty("interface.server.port"));
    	keystorePassword = pro.getProperty("keystore.password");
    	truststorePassword = pro.getProperty("truststore.password");
	}
	
	public static CloseableHttpClient getHttpsClient() throws Exception{
		CloseableHttpClient httpClient = null;
		
		String keystorePath = ApplicationUtils.getWebFileAbsoluteClassPath("vulwebsys.p12");
		KeyStore keyStore = KeyStore.getInstance(KeyStore
				.getDefaultType());
		FileInputStream inputStream = new FileInputStream(new File(keystorePath));
		
		String truststorePath = ApplicationUtils.getWebFileAbsoluteClassPath("truststore.jks");
		KeyStore trustStore = KeyStore.getInstance(KeyStore
				.getDefaultType());
		FileInputStream trustInputStream = new FileInputStream(new File(truststorePath));

		try {
			keyStore.load(inputStream,  keystorePassword.toCharArray());
			trustStore.load(trustInputStream, truststorePassword.toCharArray());
			SSLContext sslContext = SSLContexts
					.custom()
					.loadKeyMaterial(keyStore, keystorePassword.toCharArray())
					.loadTrustMaterial(trustStore,
							null).build();

			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
					sslContext, new String[] { "TLSv1" }, null,
					SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

			httpClient = HttpClients.custom().setSSLSocketFactory(sslsf)
					.build();
			return httpClient;
		} catch (Exception e) {
			throw e;
		} finally {
			if(inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(trustInputStream != null){
				try {
					trustInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public static HttpPost getHttpPost(String uri){
		HttpPost httppost = new HttpPost("https://"
					+interfaceServerIp
					+":"
					+interfaceServerPort
					+uri);
		return httppost;
	}
	
	public static <T> T postJson(String uri,Object param,Class<T> modelClass) throws Exception{
		CloseableHttpClient client = null;
		HttpPost httppost = null;
		String result = null;
		try{
			client = getHttpsClient();
			httppost = getHttpPost(uri);
			httppost.addHeader("Content-type","application/json; charset=utf-8");
			ObjectMapper om = new ObjectMapper();
			String requestBody = om.writeValueAsString(param);
			httppost.setEntity(new StringEntity(requestBody, Charset.forName("UTF-8")));
			CloseableHttpResponse response = client.execute(httppost);
			result = EntityUtils.toString(response.getEntity(), "UTF-8");
			T resBody = om.readValue(result, modelClass);
			return resBody;
		}catch(Exception e){
			throw e;
		}finally{
			if(client != null){
				client.close();
			}
		}
	}
}
