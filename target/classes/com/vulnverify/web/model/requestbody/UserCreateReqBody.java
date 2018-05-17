package com.vulnverify.web.model.requestbody;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 创建用户
 * @author linan
 * @date 2018年5月3日  
 *
 */
public class UserCreateReqBody {
	/**
	 * 用户
	 */
	@NotEmpty(message="用户名不可为空")
	private String userName;
	/**
	 * 账号
	 */
	@NotEmpty(message="账号不可为空")
	private String userAccount;
	/**
	 * 用户类型
	 */
	@NotEmpty(message="用户类型不可为空")
	private String userType;
	/**
	 * 电话
	 */
	private String telephone;
	/**
	 * 邮编
	 */
	private String mailbox;
	/**
	 * 密码
	 */
	@NotEmpty(message="密码不可为空")
	private String password;
	/**
	 * 确认密码
	 */
	@NotEmpty(message="确认密码不可为空")
	private String confirmPassword;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
