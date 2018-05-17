package com.vulnverify.web.model.requestbody;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 登录请求的请求体
 * @author linan
 *
 */
public class LoginReqBody {
	
	/**登录用户名*/
	@NotEmpty(message = "用户名不可为空")
	@Length(max=32, message="用户名最多32位字符")
	private String userAccount;
	
	/**登录密码*/
	@NotEmpty(message = "密码不可为空")
	@Length(max=32, message="密码最多32位字符")
	private String password;
	
	/**登录验证码*/
	@NotEmpty(message = "验证码不可为空")
	@Length(max=4, min=4, message="验证码必须4位")
	private String verificationCode;
	
	/**AES加密和数据签名的密码，由前端生成*/
	@NotEmpty(message = "密钥不可为空")
	@Length(max=64, message="密钥最多64位字符")
	private String userKey;

	
	public String getPassword() {
		return password;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	
}
