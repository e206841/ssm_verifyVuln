package com.vulnverify.core.entity;

import com.vulnverify.core.utils.ApplicationUtils;


/**
 * SimpleException : 用户自定义异常
 *
 * @author LiWenbin
 * @since 2017-03-17 13:23:00
 */
public class SimpleException extends RuntimeException {

	private static final long serialVersionUID = 6334302603155736419L;
	
	/**
     * 异常发生时间
     */
    private long date = System.currentTimeMillis();
    
    /**
	 * 错误编号
	 */
	private String errorCode;
	/**
	 * 错误信息
	 */
	private String errorMsg;
	
	public SimpleException(String errorCode){
		super(ApplicationUtils.getMessage(errorCode));
		this.errorCode=errorCode;
		this.errorMsg=ApplicationUtils.getMessage(errorCode);
	}
	
	public SimpleException(String errorCode,String errorMsg){
		super(errorMsg);
		this.errorCode=errorCode;
		this.errorMsg=errorMsg;
	}

    public long getDate() {
        return date;
    }

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public String getMessage(){
		return errorMsg;
	}
}
