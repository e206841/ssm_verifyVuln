package com.vulnverify.web.dao;

import java.util.List;

import com.vulnverify.core.generic.GenericDao;
import com.vulnverify.web.model.TPatchSolution;
import com.vulnverify.web.model.requestbody.PatchSolutionReqBody;

public interface TPatchSolutionMapper extends GenericDao<TPatchSolution, Integer>{
    int deleteByPrimaryKey(Integer patchId);

    int insert(TPatchSolution record);

    int insertSelective(TPatchSolution record);

    TPatchSolution selectByPrimaryKey(Integer patchId);

    int updateByPrimaryKeySelective(TPatchSolution record);

    int updateByPrimaryKey(TPatchSolution record);
    
    List<TPatchSolution> selectByVulnId(PatchSolutionReqBody requestBody);
}