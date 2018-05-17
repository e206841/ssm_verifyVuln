package com.vulnverify.web.dao;

import org.apache.ibatis.annotations.Param;

import com.vulnverify.core.generic.GenericDao;
import com.vulnverify.web.model.TSysRoleRights;

public interface TSysRoleRightsMapper extends GenericDao<TSysRoleRights,Integer>{
	
	TSysRoleRights selectByRoleIdAndRightId(@Param("roleId")Integer roleId, @Param("rightId")Integer rightId);
}