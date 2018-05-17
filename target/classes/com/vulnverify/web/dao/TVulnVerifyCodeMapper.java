package com.vulnverify.web.dao;

import java.util.List;

import com.vulnverify.core.generic.GenericDao;
import com.vulnverify.web.model.TVulnVerifyCode;
import com.vulnverify.web.model.requestbody.VulnVerifyCodeReqBody;

public interface TVulnVerifyCodeMapper extends GenericDao<TVulnVerifyCode, Integer>{
    int deleteByPrimaryKey(Integer codeFileId);

    int insert(TVulnVerifyCode record);

    int insertSelective(TVulnVerifyCode record);

    TVulnVerifyCode selectByPrimaryKey(Integer codeFileId);

    int updateByPrimaryKeySelective(TVulnVerifyCode record);

    int updateByPrimaryKey(TVulnVerifyCode record);
    
    List<TVulnVerifyCode> selectByVulnId(VulnVerifyCodeReqBody  requestBody);
}