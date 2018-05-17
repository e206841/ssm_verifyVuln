package com.vulnverify.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vulnverify.core.generic.GenericDao;
import com.vulnverify.core.generic.GenericServiceImpl;
import com.vulnverify.web.dao.TSysRightsMapper;
import com.vulnverify.web.model.TSysRights;
import com.vulnverify.web.model.view.SysRightTreeView;
import com.vulnverify.web.service.SysRightsService;



/**
 * 权限Service实现类
 *
 * @author linan
 * @since 2017年3月20日 下午15:08:03
 */
@Service
public class SysRightsServiceImpl extends GenericServiceImpl<TSysRights, Integer> implements SysRightsService {

    @Resource
    private TSysRightsMapper sysRightsMapper;

    @Override
    public GenericDao<TSysRights, Integer> getDao() {
        return sysRightsMapper;
    }
    /**
     * 根据角色id查询角色权限
     */
    @Override
    public List<TSysRights> selectSysRightsByRoleId(Integer roleId) {
        return sysRightsMapper.selectSysRightsByRoleId(roleId);
    }
}
