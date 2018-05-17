package com.vulnverify.web.dao;

import java.util.List;

import com.vulnverify.core.generic.GenericDao;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.web.model.TVulnVerifyLib;
import com.vulnverify.web.model.requestbody.VulnVerifyReqBody;
import com.vulnverify.web.model.view.VulnVerifyView;

public interface TVulnVerifyLibMapper extends GenericDao<TVulnVerifyLib, Integer>{
    int deleteByPrimaryKey(Integer vulnId);

    int insert(TVulnVerifyLib record);

    int insertSelective(TVulnVerifyLib record);

    TVulnVerifyLib selectByPrimaryKey(Integer vulnId);

    int updateByPrimaryKeySelective(TVulnVerifyLib record);

    int updateByPrimaryKey(TVulnVerifyLib record);
    
    List<VulnVerifyView> getList(Page<VulnVerifyView> page, VulnVerifyReqBody queryInfo) ;
}