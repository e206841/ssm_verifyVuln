package com.vulnverify.web.filter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vulnverify.core.entity.SimpleResult;
import com.vulnverify.core.redis.RedisDb;
import com.vulnverify.web.constant.Constant;
import com.vulnverify.web.model.TUser;

/**
 * 用户单会话登录过滤器
 * @author LiWenbin
 */
public class UserSingleSessionFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		String requestURI = httpRequest.getRequestURI();
		/*if("/user/logout".equals(requestURI)
				|| "/".equals(requestURI)){
			chain.doFilter(request, response);
			return;
		}*/
		String sessionId = getCookie(httpRequest,"SHAREJSESSIONID");
		if(sessionId != null){
			byte[] bytes = RedisDb.getObject(sessionId);
			if(bytes != null && bytes.length > 0){
				Session session= byteToSession(bytes);
				TUser su = (TUser)session.getAttribute("userInfo");
				if(su != null){
					String key = "loginUser."+su.getUserAccount();
					String loginSessionId = RedisDb.getString(key);
					if(!sessionId.equals(loginSessionId)){
						ObjectMapper om = new ObjectMapper();
						SimpleResult sr = new SimpleResult();
						sr.setCode(Constant.EXCEPTION_S0000006);
						sr.setMsg("当前用户已在别处登录,请您退出登录");
						String jsonStr = om.writeValueAsString(sr);
						response.setCharacterEncoding("UTF-8");
						response.setContentType("application/json");
						response.getWriter().write(jsonStr);
						return;
					}else{
						RedisDb.expireString(key, 1800);
					}
					String disableKey = "loginUser."+su.getUserAccount()+".disable";
					String disableSessionId = RedisDb.getString(disableKey);
					if(disableSessionId != null
							&& disableSessionId.equals(loginSessionId)){
						ObjectMapper om = new ObjectMapper();
						SimpleResult sr = new SimpleResult();
						sr.setCode(Constant.EXCEPTION_S0000007);
						sr.setMsg("当前用户已被停用");
						String jsonStr = om.writeValueAsString(sr);
						response.setCharacterEncoding("UTF-8");
						response.setContentType("application/json");
						response.getWriter().write(jsonStr);
						return;
					}
				}
			}
		}
		chain.doFilter(request, response);
	}
	
	private Session byteToSession(byte[] bytes){
        ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
        ObjectInputStream in = null;
        SimpleSession session = null;
        try {
            in = new ObjectInputStream(bi);
            session = (SimpleSession) in.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
        	if(in != null){
        		try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        	if(bi != null){
        		try {
					bi.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
    
        return session;
    }
	
	private String getCookie(HttpServletRequest request,String cookieName){
		Cookie[] cookieArr = request.getCookies();
		if(cookieArr != null){
			for(Cookie cookie : cookieArr){
				if(cookieName.equals(cookie.getName())){
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
