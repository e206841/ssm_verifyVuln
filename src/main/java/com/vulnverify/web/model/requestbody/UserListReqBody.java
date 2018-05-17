package com.vulnverify.web.model.requestbody;
/**
 * 用户列表查询条件
 * @author linan
 * @date 2018年4月24日  
 *
 */
public class UserListReqBody {
	/**
	 * 用户类型
	 */
	private String userType;
	/**
	 * 用户名
	 */
	private String userName;
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
