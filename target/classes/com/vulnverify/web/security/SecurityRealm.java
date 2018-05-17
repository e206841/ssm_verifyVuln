package com.vulnverify.web.security;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.vulnverify.web.model.TSysRights;
import com.vulnverify.web.model.TSysRole;
import com.vulnverify.web.model.TUser;
import com.vulnverify.web.service.SysRightsService;
import com.vulnverify.web.service.SysRoleService;
import com.vulnverify.web.service.UserService;

/**
 * 用户身份验证,授权 Realm 组件
 * 
 * @author linan
 **/
@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {

    @Resource
    private UserService sysUserService;
    
    @Resource
    private SysRoleService sysRoleService;
    
    @Resource
    private SysRightsService sysRightsService;
    
    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        final TUser user = (TUser)SecurityUtils.getSubject().getSession(false).getAttribute("userInfo");
        Integer roleType = user.getUserType();//用户角色
        //角色信息
        final TSysRole roleInfos = sysRoleService.selectRoleByRoleType(roleType);
        if(null!=roleInfos){
            // 添加角色
            authorizationInfo.addRole(roleInfos.getRoleName());
            //根据角色id查询角色权限
            final List<TSysRights> sysRightsList = sysRightsService.selectSysRightsByRoleId(roleInfos.getRoleId());
            for (TSysRights sysRights : sysRightsList) {
                // 添加权限
                authorizationInfo.addStringPermission(sysRights.getRightCode());
            }
        }
        return authorizationInfo;
    }

    /**
     * 身份验证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    	//身份
        String loginName = String.valueOf(token.getPrincipal());
        //密码
        String password = new String((char[]) token.getCredentials());
        TUser su = new TUser();
        su.setUserAccount(loginName);
        su.setPassword(password);
        // 通过数据库进行验证
        final TUser authentication = sysUserService.authentication(su);
        if (authentication == null) {
            throw new AuthenticationException("用户名或密码错误.");
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(loginName, password, getName());
        return authenticationInfo;
    }

}
