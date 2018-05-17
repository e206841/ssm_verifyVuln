package com.vulnverify.web.service;

import java.util.List;

import com.vulnverify.core.generic.GenericService;
import com.vulnverify.web.model.TSysRights;
import com.vulnverify.web.model.view.SysRightTreeView;


/**
 * 权限 service接口
 * 
 * @author linan
 **/
public interface SysRightsService extends GenericService<TSysRights, Integer> {

    /**
     * 通过角色id 查询角色 拥有的权限
     * 
     * @param roleId 角色id
     * @return List<SysRights> 权限集合
     */
    List<TSysRights> selectSysRightsByRoleId(Integer roleId);
}
