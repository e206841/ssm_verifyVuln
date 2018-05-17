package com.vulnverify.web.model.requestbody;

public class PlatformContainerReqBody {
	private String containerName;
	private String imageName;
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
}
