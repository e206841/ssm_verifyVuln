package com.vulnverify.web.service;



import com.vulnverify.core.generic.GenericService;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.web.model.TPlatformContainer;
import com.vulnverify.web.model.requestbody.PlatformContainerReqBody;
import com.vulnverify.web.model.view.PlatformContainerView;


/**
 * 用户接口
 * @author zhangdj
 * @date 2018年4月24日  
 *
 */
public interface PlatformContainerService extends GenericService<TPlatformContainer, Integer>{
	/**
	 * 分页查询
	 * @param page
	 * @param queryInfo
	 */
	void getList(Page<PlatformContainerView> page, PlatformContainerReqBody queryInfo);
    /**
     * 动态查询（UUID不为空）
     * @param page
     * @param queryInfo
     */	
	TPlatformContainer selectMatch(TPlatformContainer platformContainer);

}
