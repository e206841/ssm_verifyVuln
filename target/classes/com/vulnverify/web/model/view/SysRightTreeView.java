package com.vulnverify.web.model.view;

public class SysRightTreeView {
	
	private int id;
	private int pId;
	private String name;
	private int grade;
	private int rightType;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getRightType() {
		return rightType;
	}
	public void setRightType(int rightType) {
		this.rightType = rightType;
	}
	
}
