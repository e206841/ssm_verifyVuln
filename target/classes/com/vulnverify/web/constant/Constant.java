package com.vulnverify.web.constant;

/**
 * 
 * 常量类
 * @author LiWenbin
 *
 */
public class Constant {
	public static final String FRAMEWORK_REQUEST_BODY = "framework-request-body";
	public static final String FRAMEWORK_LOG_OPT_DATA = "framework-log-opt-data";
	public static final String FRAMEWORK_LOG_OPT_CONTENT = "framework-log-opt-content";
	
	/*S000表示系统*/
	/**签名验证失败*/
	public static final String EXCEPTION_S0000001 = "S0000001";
	/**请求体校验失败*/
	public static final String EXCEPTION_S0000002 = "S0000002";
	/**数据已不存在*/
	public static final String EXCEPTION_S0000003 = "S0000003";
	/**模板不正确*/
	public static final String EXCEPTION_S0000004 = "S0000004";
	/**文件不存在*/
	public static final String EXCEPTION_S0000005 = "S0000005";
	/**当前用户已在别处登录*/
	public static final String EXCEPTION_S0000006 = "S0000006";
	/**当前用户已被停用*/
	public static final String EXCEPTION_S0000007 = "S0000007";
	
	/*S001表示用户管理模块*/
	public static final String EXCEPTION_S0010004 = "S0010004";
	/**验证码不正确*/
	public static final String EXCEPTION_S0010005 = "S0010005";
	/**用户已登录*/
	public static final String EXCEPTION_S0010006 = "S0010006";
	/**密码和确认密码不一致*/
	public static final String EXCEPTION_S0010007 = "S0010007";
	/**用户名已被使用*/
	public static final String EXCEPTION_S0010008 = "S0010008";
	/**角色不存在*/
	public static final String EXCEPTION_S0010009 = "S0010009";
	/**组织不存在*/
	public static final String EXCEPTION_S0010010 = "S0010010";
	/**用户不存在*/
	public static final String EXCEPTION_S0010011 = "S0010011";
	/**邮箱已被占用*/
	public static final String EXCEPTION_S0010012 = "S0010012";
	/**
	 * 用户正在使用不能删除
	 */
	public static final String EXCEPTION_S0010013 = "S0020003";
	
	/*用户状态*/
	//启用
	public static final String USER_STATE_ABLE="1";
	//停用
	public static final String USER_STATE_UNABLE="2";
	/**
	 * mongodb 库名
	 */
	public static final String MONGODB_SF="fs";
	
	/*
	 * 补丁上传状态
	 */
	public static final String PATCH_UPLOAD_STATE_ABLE   = "1" ; //已上传
	public static final String PATCH_UPLOAD_STATE_UNABLE = "0" ; //未上传
	
	/*
	 * 验证代码上传状态
	 */
	public static final String VERIFYCODE_UPLOAD_STATE_ABLE   = "1" ; //已上传
	public static final String VERIFYCODE_UPLOAD_STATE_UNABLE = "0" ; //未上传
}
