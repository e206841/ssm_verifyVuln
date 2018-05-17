package com.vulnverify.web.dao;

import com.vulnverify.web.model.TVulnVerifyRecord;

public interface TVulnVerifyRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TVulnVerifyRecord record);

    int insertSelective(TVulnVerifyRecord record);

    TVulnVerifyRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TVulnVerifyRecord record);

    int updateByPrimaryKey(TVulnVerifyRecord record);
}