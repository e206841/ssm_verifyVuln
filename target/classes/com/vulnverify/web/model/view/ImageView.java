package com.vulnverify.web.model.view;

import java.util.Date;

/**
 * 镜像视图模型
 * @author luoxiao
 * @version 1.0
 * @created 27-04-2018 16:06:13
 */
public class ImageView {

	private Date createTime1;
	private String createTime;
	private String description;
	private String enviroment;
	private long fileSize1;
	private String fileSize;
	private String imageName;
	private String os;
	private String software;
	private int id;

	public ImageView(){

	}

	public void finalize() throws Throwable {

	}

	public Date getCreateTime1(){
		return this.createTime1;
	}

	public String getCreateTime(){
		return this.createTime;
	}
	
	public String getDescription(){
		return this.description;
	}

	public String getEnviroment(){
		return this.enviroment;
	}

	public long getFileSize1(){
		return this.fileSize1;
	}
	
	public String getFileSize(){
		return this.fileSize;
	}

	public int getId(){
		return this.id;
	}

	public String getImageName(){
		return this.imageName;
	}

	public String getOS(){
		return this.os;
	}

	public String getSoftware(){
		return this.software;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCreateTime1(Date newVal){
		this.createTime1 = newVal;
	}

	public void setCreateTime(String newVal){
		this.createTime = newVal;
	}
	
	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal){
		this.description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEnviroment(String newVal){
		this.enviroment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFileSize1(long newVal){
		this.fileSize1 = newVal;
	}

	public void setFileSize(String newVal){
		this.fileSize = newVal;
	}
	
	/**
	 * 
	 * @param newVal
	 */
	public void setId(int newVal){
		this.id = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setImageName(String newVal){
		this.imageName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOS(String newVal){
		this.os = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSoftware(String newVal){
		this.software = newVal;
	}


}