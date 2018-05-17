package com.vulnverify.core.entity;

import java.util.List;

/**
 * 
 * @author LiWenbin
 *
 * @param <T>
 */
public class PageData<T> {
	
	private String code;
	private String msg;
	private List<T> data;
	private PageInfo pageInfo;
	
	public PageInfo getPageInfo() {
		if(pageInfo == null){
			pageInfo = new PageInfo();
		}
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
}
