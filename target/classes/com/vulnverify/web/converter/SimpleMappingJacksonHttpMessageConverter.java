package com.vulnverify.web.converter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonInputMessage;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.util.TypeUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.vulnverify.core.utils.AesUtil;
import com.vulnverify.core.utils.ApplicationUtils;
import com.vulnverify.core.utils.Base64Utils;
import com.vulnverify.core.utils.FileUtil;
import com.vulnverify.core.utils.RSAUtils;
import com.vulnverify.web.constant.Constant;

public class SimpleMappingJacksonHttpMessageConverter extends MappingJackson2HttpMessageConverter {
	
	private static final MediaType TEXT_EVENT_STREAM = new MediaType("text", "event-stream");
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private PrettyPrinter ssePrettyPrinter;
	
	private String privateKey;
	
	public SimpleMappingJacksonHttpMessageConverter(){
		try {
			this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			String filePath = ApplicationUtils
	    			.getWebFileAbsoluteClassPath("privateKey");
			byte[] a = FileUtil.getContent(filePath);
			privateKey = new String(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {

		JavaType javaType = getJavaType(clazz, null);
		return readJavaType(javaType, inputMessage);
	}
	
	@Override
	public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {

		JavaType javaType = getJavaType(type, contextClass);
		return readJavaType(javaType, inputMessage);
	}
	
	private Object readJavaType(JavaType javaType, HttpInputMessage inputMessage) {
		try {
			
			int size = (int) inputMessage.getHeaders().getContentLength();
			int available = inputMessage.getBody().available();
			byte[] bytes = new byte[size];
			int off = 0;
			int readSize = 0;
			int bufferSize = 1024;
			int length = bufferSize;
			if(available < length){
				length = available;
			}
			InputStream is = inputMessage.getBody();
			while((readSize = is.read(bytes, off, length))>0){
				off = off+readSize;
				length = size - off;
				if(length > bufferSize){
					length = bufferSize;
				}
			}
//			int value = 0;
//			while((value = is.read())>0){
//				bytes[readSize] = (byte)value;
//				readSize++;
//			}
//			inputMessage.getBody().read(bytes, off, available);
//			inputMessage.getBody().read(bytes);
			
			String requestBody = new String(bytes,"UTF-8");
			List<String> headers = inputMessage.getHeaders().get("encrypt");
			if(headers != null){
				try {
					
					if(headers.get(0).equals("rsa")){//非对称加密方式，私钥解密
						
						bytes = Base64Utils.decode(requestBody);
						bytes = RSAUtils.decryptByPrivateKey(bytes, privateKey);
						requestBody = new String(bytes);
						
					}else if(headers.get(0).equals("aes")){//对称加密，key解密
						Subject subject = SecurityUtils.getSubject();
						Session session = subject.getSession(false);
						String userKey = (String)session.getAttribute("userKey");
						
				        AesUtil aesUtil = new AesUtil();
				        requestBody = aesUtil.decrypt(userKey, requestBody);
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new HttpMessageNotReadableException("Could not read JSON: " + e.getMessage(), e);
				}
			}
			
			HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			req.setAttribute(Constant.FRAMEWORK_REQUEST_BODY, requestBody);
			
			if (inputMessage instanceof MappingJacksonInputMessage) {
				Class<?> deserializationView = ((MappingJacksonInputMessage) inputMessage).getDeserializationView();
				if (deserializationView != null) {
					return this.objectMapper.readerWithView(deserializationView).forType(javaType).
							readValue(requestBody);
				}
			}
			
			return this.objectMapper.readValue(requestBody, javaType);
		}catch (IOException ex) {
			throw new HttpMessageNotReadableException("Could not read JSON document: " + ex.getMessage(), ex);
		}
	}
	
	@Override
	protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String encryptType = req.getHeader("encrypt");
		OutputStream os = outputMessage.getBody();
		if("aes".equals(encryptType)){
			os = new ByteArrayOutputStream();
		}
		
		MediaType contentType = outputMessage.getHeaders().getContentType();
		JsonEncoding encoding = getJsonEncoding(contentType);
		JsonGenerator generator = this.objectMapper.getFactory().createGenerator(os, encoding);
		try {
			writePrefix(generator, object);

			Class<?> serializationView = null;
			FilterProvider filters = null;
			Object value = object;
			JavaType javaType = null;
			if (object instanceof MappingJacksonValue) {
				MappingJacksonValue container = (MappingJacksonValue) object;
				value = container.getValue();
				serializationView = container.getSerializationView();
				filters = container.getFilters();
			}
			if (type != null && value != null && TypeUtils.isAssignable(type, value.getClass())) {
				javaType = getJavaType(type, null);
			}
			ObjectWriter objectWriter;
			if (serializationView != null) {
				objectWriter = this.objectMapper.writerWithView(serializationView);
			}
			else if (filters != null) {
				objectWriter = this.objectMapper.writer(filters);
			}
			else {
				objectWriter = this.objectMapper.writer();
			}
			if (javaType != null && javaType.isContainerType()) {
				objectWriter = objectWriter.forType(javaType);
			}
			SerializationConfig config = objectWriter.getConfig();
			if (contentType != null && contentType.isCompatibleWith(TEXT_EVENT_STREAM) &&
					config.isEnabled(SerializationFeature.INDENT_OUTPUT)) {
				objectWriter = objectWriter.with(this.ssePrettyPrinter);
			}
			objectWriter.writeValue(generator, value);

			writeSuffix(generator, object);
			generator.flush();
			
			if("aes".equals(encryptType)){
				ByteArrayOutputStream baos = (ByteArrayOutputStream)os;
				byte[] data = baos.toByteArray();
				
				Subject subject = SecurityUtils.getSubject();
				Session session = subject.getSession();
				String userKey = (String)session.getAttribute("userKey"); 
		        
		        AesUtil aesUtil = new AesUtil();
		        String base64Str = aesUtil.encrypt(userKey, new String(data));
		        
				baos.close();
				
				outputMessage.getBody().write(base64Str.getBytes());
			}

		}
		catch (JsonProcessingException ex) {
			throw new HttpMessageNotWritableException("Could not write JSON document: " + ex.getMessage(), ex);
		}
	}
}
