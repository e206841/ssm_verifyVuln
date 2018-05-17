/*package com.vulnverify.web.interceptors;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.simple.core.entity.SimpleException;
import com.simple.core.util.ApplicationUtils;
import com.simple.core.util.PasswordHash;
import com.simple.web.constant.Constant;
*//**
 * 
 * 签名认证拦截器
 * @author LiWenbin
 *
 *//*
@Aspect
public class SimpleSignAuthHandlerInterceptor {
	
	@Around(value="@annotation(com.simple.web.annotation.SimpleSign)")
	public Object proxy(ProceedingJoinPoint thisJoinPoint) throws Throwable {
		
		Object obj = null;
		try{
			
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			String userKey = (String)session.getAttribute("userKey");
			
			HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			String url = req.getRequestURI();
			if(req.getQueryString() !=null && !"".equals(req.getQueryString())){
				url = url + "?" + req.getQueryString();
			}
			String signText=url;
			String requestBody = (String)req.getAttribute(Constant.FRAMEWORK_REQUEST_BODY);
			if(requestBody != null){
				signText = signText+requestBody;
			}
			String requstSign = req.getHeader("simpleSign");
			SimpleException se = new SimpleException(Constant.EXCEPTION_S0000001,
					ApplicationUtils.getMessage(Constant.EXCEPTION_S0000001));
			if(requstSign == null){
				throw se;
			}
			String simpleSign = PasswordHash.getHmacSHA1(userKey, signText);
			if(!simpleSign.equals(requstSign)){
				throw se;
			}
			
			obj = thisJoinPoint.proceed();	//如果请求参数不正确，obj值为400
			
		}catch(Throwable e){
			throw e;
		}
		return obj;
		
	}
	
}
*/