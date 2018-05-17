package com.vulnverify.web.dao;

import java.util.List;

import com.vulnverify.core.generic.GenericDao;
import com.vulnverify.web.model.TSysRole;
/**
 * 角色mapper
 * @author linan
 * @date 2018年5月10日  
 *
 */
public interface TSysRoleMapper extends GenericDao<TSysRole, Integer>{
	
	/**
	 * 根据用户角色类型查询角色信息
	 * @param roleType
	 * @return
	 */
	TSysRole selectRoleByRoleType(int roleType);
}