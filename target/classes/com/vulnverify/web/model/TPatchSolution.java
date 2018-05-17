package com.vulnverify.web.model;

import java.util.Date;

public class TPatchSolution {
    private Integer patchId;

    private String patchNo;

    private String patchName;

    private String fileName;

    private String patchFileUrl;

    private String fileMd5;

    private Long patchFileSize;

    private String importanceGrade;

    private Integer vulnId;

    private String vulnName;

    private String createUser;

    private Date createTime;

    public Integer getPatchId() {
        return patchId;
    }

    public void setPatchId(Integer patchId) {
        this.patchId = patchId;
    }

    public String getPatchNo() {
        return patchNo;
    }

    public void setPatchNo(String patchNo) {
        this.patchNo = patchNo == null ? null : patchNo.trim();
    }

    public String getPatchName() {
        return patchName;
    }

    public void setPatchName(String patchName) {
        this.patchName = patchName == null ? null : patchName.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getPatchFileUrl() {
        return patchFileUrl;
    }

    public void setPatchFileUrl(String patchFileUrl) {
        this.patchFileUrl = patchFileUrl == null ? null : patchFileUrl.trim();
    }

    public String getFileMd5() {
        return fileMd5;
    }

    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5 == null ? null : fileMd5.trim();
    }

    public Long getPatchFileSize() {
        return patchFileSize;
    }

    public void setPatchFileSize(Long patchFileSize) {
        this.patchFileSize = patchFileSize;
    }

    public String getImportanceGrade() {
        return importanceGrade;
    }

    public void setImportanceGrade(String importanceGrade) {
        this.importanceGrade = importanceGrade == null ? null : importanceGrade.trim();
    }

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