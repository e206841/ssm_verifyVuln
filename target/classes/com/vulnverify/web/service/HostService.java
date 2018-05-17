package com.vulnverify.web.service;

import com.vulnverify.core.generic.GenericService;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.web.model.THost;
import com.vulnverify.web.model.requestbody.HostListReqBody;
import com.vulnverify.web.model.view.HostView;

/**
 * 设备接口
 * 
 * @author lihongxian
 * @date 2018年4月26日
 * 
 */
public interface HostService extends GenericService<THost, Integer>{
	/**
	 * 分页查询
	 * @param page
	 * @param queryInfo
	 */
	void getList(Page<HostView> page, HostListReqBody queryInfo);

    /**
     * 动态匹配查询（UUID不为空）
     * @param page
     * @param queryInfo
     */	
	THost selectMatch(THost host);

	
	 /**
     * 按UUID查询
     * @param page
     * @param queryInfo
     */	
	THost selectByUuid(String hostMachineUuid);


}
