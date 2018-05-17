package com.vulnverify.core.entity;

/**
 * 设备匹配扫描范围
 * @author LiWenbin
 */
/**
 * @author linan
 *
 */
public class DeviceMatchRange {
	/**
	 * 设备ID
	 */
	private Integer deviceId;
	/**
	 * 设备扫描范围
	 */
	private String range;
	/**
	 * 单位ID
	 */
	private Integer orgId;
	
	
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	/**
	 * @return the deviceId
	 */
	public Integer getDeviceId() {
		return deviceId;
	}
	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * @return the range
	 */
	public String getRange() {
		return range;
	}
	/**
	 * @param range the range to set
	 */
	public void setRange(String range) {
		this.range = range;
	}
}
