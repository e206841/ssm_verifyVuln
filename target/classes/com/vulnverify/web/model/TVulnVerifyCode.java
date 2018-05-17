package com.vulnverify.web.model;

import java.util.Date;

public class TVulnVerifyCode {
    private Integer codeFileId;

    private String codeFileName;

    private String codeFileUrl;

    private Integer vulnId;

    private String vulnName;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    public Integer getCodeFileId() {
        return codeFileId;
    }

    public void setCodeFileId(Integer codeFileId) {
        this.codeFileId = codeFileId;
    }

    public String getCodeFileName() {
        return codeFileName;
    }

    public void setCodeFileName(String codeFileName) {
        this.codeFileName = codeFileName == null ? null : codeFileName.trim();
    }

    public String getCodeFileUrl() {
        return codeFileUrl;
    }

    public void setCodeFileUrl(String codeFileUrl) {
        this.codeFileUrl = codeFileUrl == null ? null : codeFileUrl.trim();
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
}