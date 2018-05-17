package com.vulnverify.web.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vulnverify.core.generic.GenericDao;
import com.vulnverify.core.generic.GenericServiceImpl;
import com.vulnverify.web.dao.TSysRightsMapper;
import com.vulnverify.web.dao.TSysRoleMapper;
import com.vulnverify.web.model.TSysRole;
import com.vulnverify.web.service.SysRoleService;


/**
 * 角色管理 Service实现类
 *
 * @author linan
 * @since 2017年3月20日 下午14:52:33
 */
@Service
public class SysRoleServiceImpl extends GenericServiceImpl<TSysRole, Integer> implements SysRoleService {

    @Resource
    private TSysRoleMapper sysRoleMapper;
    @Resource
    private TSysRightsMapper sysRightsMapper;

    @Override
    public GenericDao<TSysRole, Integer> getDao() {
        return sysRoleMapper;
    }
    /**
     * 根据用户角色类型查询角色信息
     */
	@Override
	public TSysRole selectRoleByRoleType(int roleType) {
		return sysRoleMapper.selectRoleByRoleType(roleType);
	}

}
