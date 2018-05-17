package com.vulnverify.web.model;

import java.util.Date;

public class TSysRights {
    private Integer rightId;

    private Integer rightType;

    private String rightName;

    private String rightCode;

    private Long parentRightId;

    private String rightPath;

    private Integer sort;

    private String createUserid;

    private Date createDate;

    private Integer rightGrade;

    public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }

    public Integer getRightType() {
        return rightType;
    }

    public void setRightType(Integer rightType) {
        this.rightType = rightType;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName == null ? null : rightName.trim();
    }

    public String getRightCode() {
        return rightCode;
    }

    public void setRightCode(String rightCode) {
        this.rightCode = rightCode == null ? null : rightCode.trim();
    }

    public Long getParentRightId() {
        return parentRightId;
    }

    public void setParentRightId(Long parentRightId) {
        this.parentRightId = parentRightId;
    }

    public String getRightPath() {
        return rightPath;
    }

    public void setRightPath(String rightPath) {
        this.rightPath = rightPath == null ? null : rightPath.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(String createUserid) {
        this.createUserid = createUserid == null ? null : createUserid.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getRightGrade() {
        return rightGrade;
    }

    public void setRightGrade(Integer rightGrade) {
        this.rightGrade = rightGrade;
    }
}