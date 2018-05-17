package com.vulnverify.web.service;

import java.util.List;

import com.vulnverify.core.generic.GenericService;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.web.model.TSysRole;


/**
 * 角色管理 service接口
 * 
 * @author linan
 * @since 2017年3月20日  14:57:00
 **/
public interface SysRoleService extends GenericService<TSysRole, Integer> {
	/**
	 * 查询角色信息
	 * @param parseInt
	 * @return
	 */
	TSysRole selectRoleByRoleType(int parseInt);
}
