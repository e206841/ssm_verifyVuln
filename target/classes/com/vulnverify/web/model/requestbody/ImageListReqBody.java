package com.vulnverify.web.model.requestbody;


/**
 * 镜像列表查询
 * @author luoxiao
 * @version 1.0
 * @created 27-四月-2018 15:57:50
 */
public class ImageListReqBody {

	private String imageName;
	private String os;

	public ImageListReqBody(){

	}

	public void finalize() throws Throwable {

	}

	public String getImageName(){
		return this.imageName;
	}

	public String getOS(){
		return this.os;
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

}