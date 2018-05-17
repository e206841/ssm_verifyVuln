package com.vulnverify.web.model.requestbody;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 镜像添加请求对象
 * @author luoxiao
 * @version 1.0
 * @created 28-四月-2018 15:57:50
 */
public class ImageAddReqBody {

	@NotEmpty(message = "镜像名称不能为空")
	@Length(max=255, message="镜像名称最多255个字符")
	private String imageName;
	
	@NotEmpty(message = "镜像文件不可为空")
	@Pattern(regexp="[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}", message="镜像文件信息不正确")
	private String uuid;
	
	@NotEmpty(message = "镜像操作系统不可为空")
	@Length(max=255, message="镜像操作系统最多255个字符")
	private String os;
	private String description;
	private String enviroment;
	private String software;


	public ImageAddReqBody(){

	}

	public void finalize() throws Throwable {

	}

	public String getDescription(){
		return this.description;
	}

	public String getEnviroment(){
		return this.enviroment;
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

	public String getUUID(){
		return this.uuid;
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

	/**
	 * 
	 * @param newVal
	 */
	public void setUUID(String newVal){
		this.uuid = newVal;
	}

}
