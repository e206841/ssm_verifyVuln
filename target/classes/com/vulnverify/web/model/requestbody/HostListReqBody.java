package com.vulnverify.web.model.requestbody;

/**
 * 设备列表查询条件
 * 
 * @author lihongxian
 * @date 2018年4月26日
 * 
 */
public class HostListReqBody {
	/**
	 * 设备IP
	 */
	private String hostMachineIp;
	/**
	 * 状态
	 */
	private String status;
	public String getHostMachineIp() {
		return hostMachineIp;
	}
	public void setHostMachineIp(String hostMachineIp) {
		this.hostMachineIp = hostMachineIp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
