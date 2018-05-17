package com.vulnverify.web.model.responsebody;

/**
 * 权限明细响应体
 * @author LiWenbin
 */
public class RightResBody {
	
	/**权限ID*/
	private int id;
	/**权限父ID*/
	private Long pId;
	/**权限名称*/
	private String name;
	/**权限编码*/
	private String code;
	/**权限级别*/
	private int grade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		if(pId == null){
			this.pId = 0L;
		}else{
			this.pId = pId;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
