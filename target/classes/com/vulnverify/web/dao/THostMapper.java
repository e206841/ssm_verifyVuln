package com.vulnverify.web.dao;

import java.util.List;

import com.vulnverify.core.generic.GenericDao;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.web.model.THost;
import com.vulnverify.web.model.TImage;
import com.vulnverify.web.model.requestbody.HostListReqBody;
import com.vulnverify.web.model.view.HostView;

public interface THostMapper extends GenericDao<THost, Integer>{
    int deleteByPrimaryKey(Integer hostMachineId);

    int insert(THost record);

    int insertSelective(THost record);

    THost selectByPrimaryKey(Integer hostMachineId);

    int updateByPrimaryKeySelective(THost record);

    int updateByPrimaryKey(THost record);
    /**
     * 分页查询
     * @param page
     * @param queryInfo
     */
	List<HostView> getList(Page<HostView> page, HostListReqBody queryInfo);

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