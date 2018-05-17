package com.vulnverify.web.model.requestbody;

public class VulnVerifyReqBody {

	/*
	 * 漏洞编号
	 */
	private String vulnId;
	/*
	 * 漏洞名称
	 */
	private String vulnName;
	
	/*
	 * 补丁名称
	 */
	private String patchName;
	/*
	 * 补丁编号
	 */
	private String patchNo;
	/*
	 * 镜像id
	 */
    private String  imageId;
	
	
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public String getPatchName() {
		return patchName;
	}
	public void setPatchName(String patchName) {
		this.patchName = patchName;
	}
	public String getPatchNo() {
		return patchNo;
	}
	public void setPatchNo(String patchNo) {
		this.patchNo = patchNo;
	}
	public String getVulnId() {
		return vulnId;
	}
	public void setVulnId(String vulnId) {
		this.vulnId = vulnId;
	}
	public String getVulnName() {
		return vulnName;
	}
	public void setVulnName(String vulnName) {
		this.vulnName = vulnName;
	}
	
	
}
