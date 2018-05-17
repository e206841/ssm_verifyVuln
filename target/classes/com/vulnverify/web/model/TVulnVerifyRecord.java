package com.vulnverify.web.model;

import java.util.Date;

public class TVulnVerifyRecord {
    private Integer id;

    private Integer vulnId;

    private String vulnName;

    private String verifyContentSummary;

    private String verifyUser;

    private Date verifyTime;

    private String verifyFileUrl;

    private String verifyFileName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getVerifyContentSummary() {
        return verifyContentSummary;
    }

    public void setVerifyContentSummary(String verifyContentSummary) {
        this.verifyContentSummary = verifyContentSummary == null ? null : verifyContentSummary.trim();
    }

    public String getVerifyUser() {
        return verifyUser;
    }

    public void setVerifyUser(String verifyUser) {
        this.verifyUser = verifyUser == null ? null : verifyUser.trim();
    }

    public Date getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }

    public String getVerifyFileUrl() {
        return verifyFileUrl;
    }

    public void setVerifyFileUrl(String verifyFileUrl) {
        this.verifyFileUrl = verifyFileUrl == null ? null : verifyFileUrl.trim();
    }

    public String getVerifyFileName() {
        return verifyFileName;
    }

    public void setVerifyFileName(String verifyFileName) {
        this.verifyFileName = verifyFileName == null ? null : verifyFileName.trim();
    }
}