package com.vulnverify.web.model.responsebody;

/**
 * 
 * 登录响应体
 * @author linan
 *
 */
public class LoginResBody {
	
	/**登录用户ID*/
	private String id;
	/**登录用户名*/
	private String userAccount;
	/**登录用户姓名*/
	private String userName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
