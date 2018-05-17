package com.vulnverify.web.dao;

import java.util.List;

import com.vulnverify.core.generic.GenericDao;
import com.vulnverify.web.model.TSysRights;
import com.vulnverify.web.model.view.SysRightTreeView;
/**
 * 权限mapper
 * @author linan
 * @date 2018年5月10日  
 *
 */
public interface TSysRightsMapper extends GenericDao<TSysRights, Integer>{

	List<TSysRights> selectSysRightsByRoleId(Integer roleId);

	List<SysRightTreeView> selectRightTree();
	
	TSysRights selectByRightCode(String rightCode);
}