package com.vulnverify.init;

import java.util.List;

/**
 * 权限树节点，初始化数据库使用
 * @author linan
 *
 */
public class RightNode {

    private Integer rightType;

    private String rightName;

    private String rightCode;

    private Integer rightGrade;

    private Long parentRightId;

    private Integer sort;
    
    private List<RightNode> children;

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
		this.rightName = rightName;
	}

	public String getRightCode() {
		return rightCode;
	}

	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}

	public Integer getRightGrade() {
		return rightGrade;
	}

	public void setRightGrade(Integer rightGrade) {
		this.rightGrade = rightGrade;
	}

	public Long getParentRightId() {
		return parentRightId;
	}

	public void setParentRightId(Long parentRightId) {
		this.parentRightId = parentRightId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public List<RightNode> getChildren() {
		return children;
	}

	public void setChildren(List<RightNode> children) {
		this.children = children;
	}

}
