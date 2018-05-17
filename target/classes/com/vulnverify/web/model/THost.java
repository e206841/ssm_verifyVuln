package com.vulnverify.web.model;

import java.util.Date;
import java.math.BigDecimal;

/**
 * 设备列表
 * 
 * @author lihongxian
 * @date 2018年4月26日
 * 
 */

public class THost {
	private Integer hostMachineId;

    private String hostMachineUuid;

    private String hostMachineIp;

    private String hostName;

    private String status;

    private Integer cpuCoreNum;

    private Integer ramSize;

    private Integer diskSize;

    private BigDecimal currentDiskSize;
    
    private BigDecimal ramTotalUsage;
    
    private BigDecimal currentCpu;

    private String updateUser;

    private Date updateTime;

    private String createUser;

    private Date createTime;

    public Integer getHostMachineId() {
        return hostMachineId;
    }

    public void setHostMachineId(Integer hostMachineId) {
        this.hostMachineId = hostMachineId == null ? null : hostMachineId;
    }

    public String getHostMachineUuid() {
        return hostMachineUuid;
    }

    public void setHostMachineUuid(String hostMachineUuid) {
        this.hostMachineUuid = hostMachineUuid == null ? null : hostMachineUuid.trim();
    }

    public String getHostMachineIp() {
        return hostMachineIp;
    }

    public void setHostMachineIp(String hostMachineIp) {
        this.hostMachineIp = hostMachineIp == null ? null : hostMachineIp.trim();
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName == null ? null : hostName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
    public Integer getCpuCoreNum() {
        return cpuCoreNum;
    }

    public void setCpuCoreNum(Integer cpuCoreNum) {
        this.cpuCoreNum = cpuCoreNum == null ? null : cpuCoreNum;
    }
    public Integer getRamSize() {
        return ramSize;
    }

    public void setRamSize(Integer ramSize) {
        this.ramSize = ramSize == null ? null : ramSize;
    }
    public Integer getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(Integer diskSize) {
        this.diskSize = diskSize == null ? null : diskSize;
    }

    public BigDecimal getCurrentDiskSize() {
        return currentDiskSize;
    }

    public void setCurrentDiskSize(BigDecimal currentDiskSize) {
        this.currentDiskSize = currentDiskSize == null ? null : currentDiskSize;
    }

    public BigDecimal getRamTotalUsage() {
        return ramTotalUsage;
    }

    public void setRamTotalUsage(BigDecimal ramTotalUsage) {
        this.ramTotalUsage = ramTotalUsage == null ? null : ramTotalUsage;
    }

    public BigDecimal getCurrentCpu() {
        return currentCpu;
    }

    public void setCurrentCpu(BigDecimal currentCpu) {
        this.currentCpu = currentCpu == null ? null : currentCpu;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}