package com.vulnverify.web.model.view;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 设备列表
 * 
 * @author lihongxian
 * @date 2018年4月26日
 * 
 */
public class HostView {
	/**
	 * 宿主机ID
	 */
	private Integer hostMachineId;
	/**
	 * 宿主机UUID
	 */
    private String hostMachineUuid;
    /**
	 * 宿主机IP
	 */
    private String hostMachineIp;
    /**
	 * 宿主机名
	 */
    private String hostName;
    /**
	 * 设备状态
	 */
    private String status;
    /**
	 * CPU内核
	 */
    private Integer cpuCoreNum;
    /**
	 * 内存容量
	 */
    private Integer ramSize;
    /**
	 * 硬盘容量
	 */
    private Integer diskSize;
    /**
	 * 当前磁盘大小
	 */
    private BigDecimal currentDiskSize;
    /**
	 * 当前内存使用
	 */
    private BigDecimal ramTotalUsage;
    /**
	 * 当前CPU使用
	 */
    private BigDecimal currentCpu;
    
	/**
	 * 更新人
	 */
	private String updateUser;
	/**
	 * 更新时间
	 */
	private String updateTime;
	
	public Integer getHostMachineId() {
        return hostMachineId;
    }

    public void setHostMachineId(Integer hostMachineId) {
        this.hostMachineId = hostMachineId;
    }

    public String getHostMachineUuid() {
        return hostMachineUuid;
    }

    public void setHostMachineUuid(String hostMachineUuid) {
        this.hostMachineUuid = hostMachineUuid;
    }

    public String getHostMachineIp() {
        return hostMachineIp;
    }

    public void setHostMachineIp(String hostMachineIp) {
        this.hostMachineIp = hostMachineIp;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getCpuCoreNum() {
        return cpuCoreNum;
    }

    public void setCpuCoreNum(Integer cpuCoreNum) {
        this.cpuCoreNum = cpuCoreNum;
    }
    public Integer getRamSize() {
        return ramSize;
    }

    public void setRamSize(Integer ramSize) {
        this.ramSize = ramSize;
    }
    public Integer getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(Integer diskSize) {
        this.diskSize = diskSize;
    }

    public BigDecimal getCurrentDiskSize() {
        return currentDiskSize;
    }

    public void setCurrentDiskSize(BigDecimal currentDiskSize) {
        this.currentDiskSize = currentDiskSize;
    }

    public BigDecimal getRamTotalUsage() {
        return ramTotalUsage;
    }

    public void setRamTotalUsage(BigDecimal ramTotalUsage) {
        this.ramTotalUsage = ramTotalUsage;
    }

    public BigDecimal getCurrentCpu() {
        return currentCpu;
    }

    public void setCurrentCpu(BigDecimal currentCpu) {
        this.currentCpu = currentCpu;
    }    
	
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}	
}
