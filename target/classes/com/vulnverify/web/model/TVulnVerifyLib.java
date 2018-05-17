package com.vulnverify.web.model;

import java.util.Date;

public class TVulnVerifyLib {
    private Integer vulnId;

    private String vulnName;

    private String cnnvdNo;

    private String cveNo;

    private String compamny;

    private String vulnSource;

    private String vulnDescription;

    private String vulnPublicBoard;

    private String refrenceWebsite;

    private String vulnSoftwareList;

    private String vulnSolution;

    private Integer imageId;

    private String imageName;

    private String vulnTypeKey;

    private String vulnSeverityKey;

    private String vulnThreatTypeKey;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String verifycodestatus;

    private String patchstatus;

    public Integer getVulnId() {
        return vulnId;
    }

    public void setVulnId(Integer vulnId) {
        this.vulnId = vulnId;
    }

    public String getVulnName() {
        return vulnName;
    }

    public void setVulnName(String vulnName) {
        this.vulnName = vulnName == null ? null : vulnName.trim();
    }

    public String getCnnvdNo() {
        return cnnvdNo;
    }

    public void setCnnvdNo(String cnnvdNo) {
        this.cnnvdNo = cnnvdNo == null ? null : cnnvdNo.trim();
    }

    public String getCveNo() {
        return cveNo;
    }

    public void setCveNo(String cveNo) {
        this.cveNo = cveNo == null ? null : cveNo.trim();
    }

    public String getCompamny() {
        return compamny;
    }

    public void setCompamny(String compamny) {
        this.compamny = compamny == null ? null : compamny.trim();
    }

    public String getVulnSource() {
        return vulnSource;
    }

    public void setVulnSource(String vulnSource) {
        this.vulnSource = vulnSource == null ? null : vulnSource.trim();
    }

    public String getVulnDescription() {
        return vulnDescription;
    }

    public void setVulnDescription(String vulnDescription) {
        this.vulnDescription = vulnDescription == null ? null : vulnDescription.trim();
    }

    public String getVulnPublicBoard() {
        return vulnPublicBoard;
    }

    public void setVulnPublicBoard(String vulnPublicBoard) {
        this.vulnPublicBoard = vulnPublicBoard == null ? null : vulnPublicBoard.trim();
    }

    public String getRefrenceWebsite() {
        return refrenceWebsite;
    }

    public void setRefrenceWebsite(String refrenceWebsite) {
        this.refrenceWebsite = refrenceWebsite == null ? null : refrenceWebsite.trim();
    }

    public String getVulnSoftwareList() {
        return vulnSoftwareList;
    }

    public void setVulnSoftwareList(String vulnSoftwareList) {
        this.vulnSoftwareList = vulnSoftwareList == null ? null : vulnSoftwareList.trim();
    }

    public String getVulnSolution() {
        return vulnSolution;
    }

    public void setVulnSolution(String vulnSolution) {
        this.vulnSolution = vulnSolution == null ? null : vulnSolution.trim();
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName == null ? null : imageName.trim();
    }

    public String getVulnTypeKey() {
        return vulnTypeKey;
    }

    public void setVulnTypeKey(String vulnTypeKey) {
        this.vulnTypeKey = vulnTypeKey == null ? null : vulnTypeKey.trim();
    }

    public String getVulnSeverityKey() {
        return vulnSeverityKey;
    }

    public void setVulnSeverityKey(String vulnSeverityKey) {
        this.vulnSeverityKey = vulnSeverityKey == null ? null : vulnSeverityKey.trim();
    }

    public String getVulnThreatTypeKey() {
        return vulnThreatTypeKey;
    }

    public void setVulnThreatTypeKey(String vulnThreatTypeKey) {
        this.vulnThreatTypeKey = vulnThreatTypeKey == null ? null : vulnThreatTypeKey.trim();
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

    public String getVerifycodestatus() {
        return verifycodestatus;
    }

    public void setVerifycodestatus(String verifycodestatus) {
        this.verifycodestatus = verifycodestatus == null ? null : verifycodestatus.trim();
    }

    public String getPatchstatus() {
        return patchstatus;
    }

    public void setPatchstatus(String patchstatus) {
        this.patchstatus = patchstatus == null ? null : patchstatus.trim();
    }
}