package com.vulnverify.web.dao;

import java.util.List;

import com.vulnverify.core.generic.GenericDao;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.web.model.TPlatformContainer;
import com.vulnverify.web.model.requestbody.PlatformContainerReqBody;
import com.vulnverify.web.model.view.PlatformContainerView;
import com.vulnverify.web.model.view.VulnVerifyView;

public interface TPlatformContainerMapper extends GenericDao<TPlatformContainer,Integer> {
    int deleteByPrimaryKey(Integer containerId);

    int insert(TPlatformContainer record);

    int insertSelective(TPlatformContainer record);

    TPlatformContainer selectByPrimaryKey(Integer containerId);

    int updateByPrimaryKeySelective(TPlatformContainer record);

    int updateByPrimaryKey(TPlatformContainer record);
    /**
     * 分页查询
     * @param page
     * @param queryInfo
     */
	List<VulnVerifyView> getList(Page<PlatformContainerView> page, PlatformContainerReqBody queryInfo);
    /**
     * 动态匹配查询（UUID不为空）
     * @param page
     * @param queryInfo
     */	
	TPlatformContainer selectMatch(TPlatformContainer platformContainer);
}