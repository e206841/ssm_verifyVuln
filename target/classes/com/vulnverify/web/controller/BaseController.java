package com.vulnverify.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vulnverify.core.entity.PageData;
import com.vulnverify.core.entity.PageQuery;
import com.vulnverify.core.entity.Result;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.core.redis.RedisDb;
import com.vulnverify.core.utils.CustomDateFormat;
import com.vulnverify.core.utils.FileUtil;
import com.vulnverify.core.utils.GeneralMongoDbUtil;
import com.vulnverify.web.constant.Constant;
import com.vulnverify.web.model.TUser;

/**
 * control层基础类，包含一些常用方法
 * @author LiWenbin
 */
public class BaseController {
	
	public static final ObjectMapper om = new ObjectMapper();
	
	
	/**
	 * 将前端传入的分页参数对象转换为服务端的分页对象
	 * @param pageQuery	前端分页对象
	 * @return	服务端分页对象
	 */
	public <T, T1> Page<T> generatePage(PageQuery<T1> pageQuery){
		int pageIndex = pageQuery.getPageInfo().getIndex();
		int pageSize = pageQuery.getPageInfo().getSize();
		return new Page<T>(pageIndex,pageSize);
	}
	
	/**
	 * 将服务端的分页对象转换为前端分页对象
	 * @param page	服务端分页对象
	 * @return	前端分页对象
	 */
	public <T> PageData<T> generatePageData(Page<T> page){
		PageData<T> pageData = new PageData<T>();
		pageData.setCode("000");
		pageData.setMsg("succeed querying");
		pageData.setData(page.getResult());
		pageData.getPageInfo().setCount(page.getTotalCount());
		pageData.getPageInfo().setIndex(page.getPageNo());
		pageData.getPageInfo().setSize(page.getPageSize());
		return pageData;
	}
	
	/**
	 * 将服务端分页对象转化为前端分页对象
	 * @param page	服务端分页对象
	 * @param T1	前端数据模型
	 * @return	前端分页对象
	 */
	public <T,T1> PageData<T1> generatePageData(Page<T> page,Class<T1> T1){
		PageData<T1> pageData = new PageData<T1>();
		pageData.setCode("000");
		pageData.setMsg("succeed querying");
		pageData.getPageInfo().setCount(page.getTotalCount());
		pageData.getPageInfo().setIndex(page.getPageNo());
		pageData.getPageInfo().setSize(page.getPageSize());
		return pageData;
	}
	
	/**
	 * 生成成功提示对象
	 * @return	成功提示对象
	 */
	public <T> Result<T> generateResultData(){
		Result<T> result = new Result<T>();
		result.setCode("000");
		result.setMsg("succeed !!!");
		return result;
	}
	
	/**
	 * 生成成功提示对象，包含数据
	 * @param data	数据
	 * @return	成功提示对象
	 */
	public <T> Result<T> generateResultData(T data){
		Result<T> result = new Result<T>();
		result.setCode("000");
		result.setMsg("succeed !!!");
		result.setData(data);
		return result;
	}
	
	/**
	 * 生成错误提示对象
	 * @return	错误提示对象
	 */
	public <T> Result<T> generateFailedData(){
		Result<T> result = new Result<T>();
		result.setCode("004");
		result.setMsg("failed !!!");
		return result;
	}
	
	/**
	 * 生成错误提示对象，包含错误消息和数据
	 * @return	错误提示对象
	 */
	public <T> Result<T> generateFailedData(T data,String msg){
		Result<T> result = new Result<T>();
		result.setCode("004");
		result.setMsg(msg);
		result.setData(data);
		return result;
	}
	
	/**
	 * 将源数据体中的属性值赋值到目标对象中
	 * @param from	源数据体
	 * @param targetClass	目标类
	 * @return	目标对象
	 */
	public <T> T convertValue(Object from,Class<T> targetClass){
		ObjectMapper om = new ObjectMapper();
		DateFormat sdf = new CustomDateFormat();
		om.setDateFormat(sdf);
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return om.convertValue(from, targetClass);
	}
	
	
	/**
	 * 获取登录用户
	 * @return 当前用户
	 */
	public TUser getLoginUser(){
		return (TUser) SecurityUtils.getSubject().getSession().getAttribute("userInfo");
	}
	
	/**
	 * 将临时文件存入redis，有效期设为30s，
	 * 如果30分钟内客户端未下载该文件，redis会自动删除
	 * @param key  redis的key
	 * @param tempFile 临时文件对象
	 * @param fileAlias 文件别名
	 * @throws IOException	IO异常
	 */
	public void saveTempFileToRedis(String key,File tempFile,String fileAlias) throws IOException{
		byte[] content = FileUtil.getContent(tempFile.getAbsolutePath());
        RedisDb.setObject(key, content);
        RedisDb.expireObject(key, 1800);
        RedisDb.setString(key+".alias", fileAlias);
        RedisDb.expireString(key+".alias", 1800);
	}
	
	/**
	 * 将临时文件存入redis，有效期设为30min，
	 * 如果30分钟内客户端未下载该文件，redis会自动删除
	 * @param key  redis的key
	 * @param tempFile 临时文件对象
	 * @throws IOException	IO异常
	 */
	public void saveVulnSubmitAttactmentsToRedis(String key,File tempFile) throws IOException{
		byte[] content = FileUtil.getContent(tempFile.getAbsolutePath());
        RedisDb.setObject(key, content);
        RedisDb.expireObject(key, 1800);
	}
	
	/**
	 * 生成成功提示对象，包含数据
	 * @param data	数据
	 * @return	成功提示对象
	 */
	public <T> Result<T> vulnResultData(T data,String msg){
		Result<T> result = new Result<T>();
		result.setCode("000");
		result.setMsg(msg);
		result.setData(data);
		return result;
	}
	
	public String [][] uploadFiles(List<MultipartFile> files) throws IOException{
		int length = files.size();
		String [][]fileInfo = new String[length][3];
		for(int i=0;i<length;i++){
			MultipartFile uploadFile= files.get(i);
			String originalFilename = uploadFile.getOriginalFilename();//文件名
			InputStream inputStream = uploadFile.getInputStream();
			long fileSize = uploadFile.getSize();
//			String type = uploadFile.getContentType();//文件类型
			String fileId = GeneralMongoDbUtil.uploadFileToGridFS(originalFilename,inputStream,Constant.MONGODB_SF,true);
			//保存文件表数据
		    fileInfo[i][0] = originalFilename;
		    fileInfo[i][1] = fileId;
		    fileInfo[i][2] = fileSize+"";

		}
		return fileInfo;
	}
	
	
}
