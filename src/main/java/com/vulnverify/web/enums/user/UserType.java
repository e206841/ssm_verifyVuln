package com.vulnverify.web.enums.user;
/**
 * 用户类型
 * @author linan
 *
 */
public enum UserType {
	VULN_VERIFY("漏洞验证人员",1),SYS_MANAGER("环境管理人员",2);
	private String name;
	private Integer index;
	
	private UserType(String name,Integer index){
		this.name=name;
		this.index=index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	
}
