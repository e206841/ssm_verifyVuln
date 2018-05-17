package com.vulnverify.web.security;

import javax.servlet.ServletRequest;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

/**
 * 重写onStart，避免在登录链接中加入sessionID
 * @author LiWenbin
 */
public class WebSessionManager extends DefaultWebSessionManager {
	
	@Override  
    protected void onStart(Session session, SessionContext context) {  
        super.onStart(session, context);  
        ServletRequest request = WebUtils.getRequest(context);  
//        request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,ShiroHttpServletRequest.COOKIE_SESSION_ID_SOURCE);  
    }  
}
