package com.vulnverify.web.resolver;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpConnectException;
import org.springframework.core.Ordered;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import com.vulnverify.core.entity.SimpleException;
import com.vulnverify.core.entity.SimpleResult;
import com.vulnverify.web.constant.Constant;
import com.vulnverify.web.dao.TSysRightsMapper;
import com.vulnverify.web.model.TSysRights;


/**
 * 异常信息拦截
 * @author LiWenbin
 *
 */
public class SimpleExceptionResolver extends AbstractHandlerExceptionResolver {
	
	private final static Logger logger = LoggerFactory.getLogger(SimpleExceptionResolver.class);
	@Resource
	private TSysRightsMapper sysRightsMapper;
	
	public SimpleExceptionResolver() {
		setOrder(Ordered.HIGHEST_PRECEDENCE);
	}

	
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
//		HandlerMethod hm = (HandlerMethod)handler;
		SimpleResult sr = new SimpleResult();
		if(ex instanceof SimpleException){
			SimpleException se = (SimpleException)ex;
			sr.setCode(se.getErrorCode());
			sr.setMsg(se.getErrorMsg());
//			logger.error(hm.getMethod().getName()+":"+se.getErrorMsg());
		}else if(ex instanceof AuthenticationException){
			sr.setCode("002");
			sr.setMsg(ex.getMessage());
			logger.error(((AuthenticationException)ex).getMessage());
		}else if(ex instanceof AuthorizationException){
			sr.setCode("003");
			String msg = ex.getMessage();
			if(msg !=null){
				int startIndex = msg.indexOf("[");
				int endIndex = msg.indexOf("]");
				String rightCode = msg.substring(startIndex+1, endIndex);
				TSysRights sysRight = sysRightsMapper.selectByRightCode(rightCode);
				if(sysRight == null){
					sr.setMsg("无'"+rightCode+"'的权限");
				}else{
					sr.setMsg("无'"+sysRight.getRightName()+"'的权限");
				}
			}else{
				sr.setMsg(ex.getMessage());
			}
			logger.error(((AuthorizationException)ex).getMessage());
		}else if(ex instanceof HttpMessageNotReadableException){
			ex.printStackTrace();
			if(((HttpMessageNotReadableException)ex).getRootCause() == null){
				sr.setCode(Constant.EXCEPTION_S0000002);
				sr.setMsg("请求体格式不合法");
				ex.printStackTrace();
			}else{
				String msg = ((HttpMessageNotReadableException)ex).getRootCause().getMessage();
				logger.error(msg);
				sr.setCode(Constant.EXCEPTION_S0000002);
				sr.setMsg(msg);
			}
		}else if(ex instanceof MethodArgumentNotValidException){
			String msg = getValidExceptionMsg((MethodArgumentNotValidException)ex);
			logger.error(msg);
			sr.setCode(Constant.EXCEPTION_S0000002);
			sr.setMsg(msg);
		}else if(ex instanceof AmqpConnectException){
			sr.setCode("001");
			sr.setMsg("消息队列连接失败");
			logger.error("runtime exception:",ex);
		}else if(ex.getMessage() != null){
			sr.setCode("001");
			sr.setMsg(ex.getMessage());
			logger.error("runtime exception:",ex);
		}else{
			sr.setCode("001");
			sr.setMsg("程序运行异常");
			logger.error("runtime exception:",ex);
		}
		
		ObjectMapper om = new ObjectMapper();
		String result=null;
		try {
			result = om.writerWithDefaultPrettyPrinter().writeValueAsString(sr);
			response.setStatus(200);
			if("application/json".equals(request.getContentType())){
				response.setContentType("application/json;charset=utf-8");
			}else{
				response.setContentType("text/html;charset=utf-8");
			}
			response.getWriter().write(result);
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		ModelAndView mv = new ModelAndView("exception");
//		request.setAttribute("exception", ex);
		return new ModelAndView();
	}
	
	private String getValidExceptionMsg(MethodArgumentNotValidException ex){
		BindingResult br = ex.getBindingResult();
		return br.getAllErrors().get(0).getDefaultMessage();
	}

}
