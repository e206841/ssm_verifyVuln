package com.vulnverify.web.model.view;

import java.util.Date;

public class PlatformContainerView {
	private int containerId;
	private String containerName;
	private String imageName;
	private String status;
	private int cpuCoreNum;
	private int ramSize;
	private int diskSize;
	private Date createTime;
	private String hostName;
	private String discription;
	private String ip;
	private String vncPort;
	private String noVncPort;
	private String vncPassword;
	private String passWord;
	private String reqCount;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getVncPort() {
		return vncPort;
	}
	public void setVncPort(String vncPort) {
		this.vncPort = vncPort;
	}
	public String getNoVncPort() {
		return noVncPort;
	}
	public void setNoVncPort(String noVncPort) {
		this.noVncPort = noVncPort;
	}
	public String getVncPassword() {
		return vncPassword;
	}
	public void setVncPassword(String vncPassword) {
		this.vncPassword = vncPassword;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getContainerId() {
		return containerId;
	}
	public void setContainerId(int containerId) {
		this.containerId = containerId;
	}
	public String getContainerName() {
		return containerName;
	}
	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCpuCoreNum() {
		return cpuCoreNum;
	}
	public void setCpuCoreNum(int cpuCoreNum) {
		this.cpuCoreNum = cpuCoreNum;
	}
	public int getRamSize() {
		return ramSize;
	}
	public void setRamSize(int ramSize) {
		this.ramSize = ramSize;
	}
	public int getDiskSize() {
		return diskSize;
	}
	public void setDiskSize(int diskSize) {
		this.diskSize = diskSize;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getReqCount() {
		return reqCount;
	}
	public void setReqCount(String reqCount) {
		this.reqCount = reqCount;
	}
}
