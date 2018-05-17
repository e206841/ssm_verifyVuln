package com.vulnverify.core.entity;

/**
 * 
 * @author LiWenbin
 *
 */
public class PageQuery<T> {
	
	private PageInfo pageInfo;
	private T queryInfo;
	
	public PageInfo getPageInfo() {
		if(pageInfo == null){
			pageInfo = new PageInfo();
			pageInfo.setIndex(1);
			pageInfo.setSize(15);
		}
		return pageInfo;
	}
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
	
	public T getQueryInfo() {	
		
		return queryInfo;
	}
	public void setQueryInfo(T queryInfo) {
		this.queryInfo = queryInfo;
	}
	
}
