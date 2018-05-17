package com.vulnverify.web.model.view;

/**
 * 用户列表
 * 
 * @author linan
 * @date 2018年4月24日
 * 
 */
public class UserView {
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 类型
	 */
	private String userType;
	/**
	 * 用户类型名
	 */
	private String userTypeName;
	/**
	 * 账号
	 */
	private String userAccount;
	/**
	 * 电话
	 */
	private String telephone;
	/**
	 * 邮编
	 */
	private String mailbox;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 更新人
	 */
	private String updateUser;
	/**
	 * 更新时间
	 */
	private String updateTime;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMailbox() {
		return mailbox;
	}
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserTypeName() {
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
}
