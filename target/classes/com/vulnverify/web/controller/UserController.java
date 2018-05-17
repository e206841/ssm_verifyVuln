package com.vulnverify.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vulnverify.core.entity.PageData;
import com.vulnverify.core.entity.PageQuery;
import com.vulnverify.core.entity.SimpleException;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.core.redis.RedisDb;
import com.vulnverify.core.utils.ApplicationUtils;
import com.vulnverify.web.constant.Constant;
import com.vulnverify.web.dao.TSysRoleRightsMapper;
import com.vulnverify.web.model.TSysRights;
import com.vulnverify.web.model.TSysRole;
import com.vulnverify.web.model.TUser;
import com.vulnverify.web.model.requestbody.IdReqBody;
import com.vulnverify.web.model.requestbody.LoginReqBody;
import com.vulnverify.web.model.requestbody.UserCreateReqBody;
import com.vulnverify.web.model.requestbody.UserListReqBody;
import com.vulnverify.web.model.requestbody.UserModifyReqBody;
import com.vulnverify.web.model.responsebody.LoginResBody;
import com.vulnverify.web.model.responsebody.RightResBody;
import com.vulnverify.web.model.view.UserView;
import com.vulnverify.web.security.PermissionSign;
import com.vulnverify.web.service.SysRightsService;
import com.vulnverify.web.service.SysRoleService;
import com.vulnverify.web.service.UserService;


/**
 * 用户控制类
 * @author linan
 * @date 2018年4月23日  
 *
 */
@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController{
	private static Logger logger=LoggerFactory.getLogger(UserController.class);
	@Resource
	private UserService userService;
	@Resource
	private SysRightsService sysRightsService;
	@Resource
	private SysRoleService sysRoleService;
	 /**验证码验证是否开启的标识*/
    @Value("${verfication.code.check}")  
    private String verficationCodeCheck = "true";

	/**
	 * 登陆
	 * @param loginBody
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(@Valid @RequestBody LoginReqBody loginBody,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession(false);
    	try{
            
            //验证码
    		/*String verificationCode = (String)session.getAttribute("verificationCode");
            if("true".equals(verficationCodeCheck)){
            	if(verificationCode == null || !verificationCode.equalsIgnoreCase(loginBody.getVerificationCode())){
                	throw new SimpleException(Constant.EXCEPTION_S0010005,
                			ApplicationUtils.getMessage(Constant.EXCEPTION_S0010005));
                }
            }*/
            
            if (subject.isAuthenticated()) {
            	throw new SimpleException(Constant.EXCEPTION_S0010006,
            			ApplicationUtils.getMessage(Constant.EXCEPTION_S0010006));
            }
            
            final TUser authUserInfo = userService.getUserByUserAccout(loginBody.getUserAccount());
            if(null==authUserInfo){
            	throw new Exception("用户不存在");
            }
            if(authUserInfo != null){
            	if(authUserInfo.getStatus() == Constant.USER_STATE_UNABLE){
            		throw new Exception("用户"+authUserInfo.getUserAccount()+"已被停用");
            	}
            }
            //登陆，并调用shrio的自定义realm的doGetAuthenticationInfo验证身份
            subject.login(
            		new UsernamePasswordToken(
            				loginBody.getUserAccount(), ApplicationUtils.sha256Hex(loginBody.getPassword())));
            
            session.setAttribute("userInfo", authUserInfo);
            session.setAttribute("userKey",loginBody.getUserKey());
            logger.info("login userKey is "+session.getId()+":"+loginBody.getUserKey());
            
            LoginResBody lrb = new LoginResBody();
            lrb.setId(authUserInfo.getUserId()+"");
            lrb.setUserAccount(authUserInfo.getUserAccount());
            lrb.setUserName(authUserInfo.getUserName());
            return generateResultData(lrb);
    	}catch(Exception e){
    		TUser sysUser = userService.getUserByUserAccout(loginBody.getUserAccount());
    		if(sysUser != null){
    			session.setAttribute("failUserInfo", sysUser);
//    			ApplicationUtils.optData2Request(sysUser.getUserName());
    		}
    		throw e;
    	}finally{
    		session.removeAttribute("verificationCode");
    	}
	}
	/**
	 * 用户列表
	 * @param pageQuery
	 * @return
	 */
	@RequestMapping(value = "/list")
	@ResponseBody
	@RequiresPermissions(value = PermissionSign.GET_USER_LIST)
	public Object list(@RequestBody PageQuery<UserListReqBody> pageQuery) {
		logger.info("获取用户列表");
		Page<UserView> page = generatePage(pageQuery);
		
		userService.getList(page, pageQuery.getQueryInfo());

		PageData<UserView> generatePageData = generatePageData(page);

		return generatePageData;
	}
	/**
	 * 创建用户
	 * @param requestBody
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/create")
	@ResponseBody
	@RequiresPermissions(value = PermissionSign.USER_CREATE)
	public Object create(@RequestBody UserCreateReqBody requestBody) throws Exception{
		//密码和确认密码是否一致
		if(!requestBody.getPassword().equals(requestBody.getConfirmPassword())){
    		throw new SimpleException(Constant.EXCEPTION_S0010007,
    				ApplicationUtils.getMessage(Constant.EXCEPTION_S0010007));
    	}
		TUser sysUser = userService.getUserByUserAccout(requestBody.getUserAccount());
		//用户是否已存在
    	if(sysUser != null){
    		throw new SimpleException(Constant.EXCEPTION_S0010008,
    				ApplicationUtils.getMessage(Constant.EXCEPTION_S0010008));
    	}
    	String mailbox = requestBody.getMailbox();
		if(null!=mailbox&&!"".equals(mailbox)){
			TUser tUser = userService.selectByEmail(mailbox);
			if (tUser != null) {
				throw new SimpleException(Constant.EXCEPTION_S0010012,
	    				ApplicationUtils.getMessage(Constant.EXCEPTION_S0010012));
			}
		}
    	TUser user=new TUser();
    	user.setCreateTime(new Date());
    	user.setMailbox(requestBody.getMailbox());
    	user.setPassword(requestBody.getPassword());
    	user.setStatus(Constant.USER_STATE_ABLE);
    	user.setTelephone(requestBody.getTelephone());
    	user.setUpdateTime(new Date());
    	user.setUserAccount(requestBody.getUserAccount());
    	user.setUserName(requestBody.getUserName());
    	user.setUserType(Integer.parseInt(requestBody.getUserType()));
    	TUser loginUser = getLoginUser();
    	user.setCreateUser(loginUser.getUserId());
    	user.setUpdateUser(loginUser.getUserId());
    	userService.createUser(user);
        return generateResultData();
	}
	/**
	 * 修改用户
	 * @param requestBody
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/modify")
	@ResponseBody
	@RequiresPermissions(value = PermissionSign.USER_MODIFY)
	public Object modify(@RequestBody UserModifyReqBody requestBody) throws Exception{
		try{
			TUser sysUser = userService.selectById(requestBody.getUserId());
			TUser user=new TUser();
	    		if(sysUser == null){
	    			throw new SimpleException(Constant.EXCEPTION_S0010011,
	        				ApplicationUtils.getMessage(Constant.EXCEPTION_S0010011));
	    		}
	    		if(requestBody.getPassword() != null){
	        		if(!requestBody.getPassword().equals(requestBody.getConfirmPassword())){
	            		throw new SimpleException(Constant.EXCEPTION_S0010007,
	            				ApplicationUtils.getMessage(Constant.EXCEPTION_S0010007));
	            	}
	        		user.setPassword(ApplicationUtils.sha256Hex(requestBody.getPassword()));
	        	}
	    		String mailbox = requestBody.getMailbox();
	    		if(null!=mailbox&&!"".equals(mailbox)){
	    			
	    			TUser tUser = userService.selectByEmail(mailbox);
	    			if (tUser != null) {
	    				if(!tUser.getUserId().equals(requestBody.getUserId())){
	    				throw new SimpleException(Constant.EXCEPTION_S0010012,
	    	    				ApplicationUtils.getMessage(Constant.EXCEPTION_S0010012));
	    				}
	    			}
	    		}
	    		user.setUserId(requestBody.getUserId());
	        	user.setMailbox(requestBody.getMailbox());
	        	user.setTelephone(requestBody.getTelephone());
	        	user.setUpdateTime(new Date());
	        	user.setUserAccount(requestBody.getUserAccount());
	        	user.setUserName(requestBody.getUserName());
	        	user.setUserType(Integer.parseInt(requestBody.getUserType()));
	        	/*SysUser optUser = (SysUser)SecurityUtils.getSubject().getSession().getAttribute("userInfo");
	        	user.setUpdateUser(optUser.getUserId());*/
	        	userService.modifyUser(user);
	        	return generateResultData();
			}catch (Exception e) {
            	throw e;
			}
	}
	/**
	 * 启用用户
	 */
	@RequestMapping(value = "/enable")
	@ResponseBody
	@RequiresPermissions(value = PermissionSign.USER_ENABLE)
	public Object enable(@RequestBody IdReqBody requestBody) throws Exception{
		TUser sysUser = userService.selectById(requestBody.getId());
    		if(sysUser == null){
    			throw new SimpleException(Constant.EXCEPTION_S0010011,
        				ApplicationUtils.getMessage(Constant.EXCEPTION_S0010011));
    		}
    		TUser user=new TUser();
    		user.setUserId(requestBody.getId());
    		user.setStatus(Constant.USER_STATE_ABLE);
        	userService.modifyUser(user);
            return generateResultData();
	}
	/**
	 * 停用用户
	 */
	@RequestMapping(value = "/disable")
	@ResponseBody
	@RequiresPermissions(value = PermissionSign.USER_DISABLE)
	public Object disable(@RequestBody IdReqBody requestBody) throws Exception{
		TUser sysUser = userService.selectById(requestBody.getId());
    		if(sysUser == null){
    			throw new SimpleException(Constant.EXCEPTION_S0010011,
        				ApplicationUtils.getMessage(Constant.EXCEPTION_S0010011));
    		}
    		
			String key = "loginUser."+sysUser.getUserAccount();
			String loginSessionId = RedisDb.getString(key);
			if(loginSessionId != null){
				key = "loginUser."+sysUser.getUserAccount()+".disable";
				RedisDb.setString(key, loginSessionId);
				RedisDb.expireString(key, 1800);
			}
    		
    		TUser user=new TUser();
    		user.setUserId(requestBody.getId());
    		user.setStatus(Constant.USER_STATE_UNABLE);
        	userService.modifyUser(user);
            return generateResultData();
	}
	/**
	 * 删除用户
	 */
	@RequestMapping(value = "/remove")
	@ResponseBody
	@RequiresPermissions(value = PermissionSign.USER_REMOVE)
	public Object remove(HttpServletRequest httpServletRequest,@RequestBody IdReqBody requestBody) throws Exception{
		TUser sysUser = userService.selectById(requestBody.getId());
		
	/*	TUser user = (TUser) httpServletRequest.getSession().getAttribute("userInfo");
		if(sysUser.getUserAccount().equals(user.getUserAccount())){
			throw new SimpleException(Constant.EXCEPTION_S0010013,
    				ApplicationUtils.getMessage(Constant.EXCEPTION_S0010013));
		}*/
    		if(sysUser == null){
    			throw new SimpleException(Constant.EXCEPTION_S0010011,
        				ApplicationUtils.getMessage(Constant.EXCEPTION_S0010011));
    		}
        	userService.removeUser(requestBody.getId());
            return generateResultData();
	}
	/**
	 * 登出
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public Object logout(){
	        SecurityUtils.getSubject().logout();
	        return generateResultData();
	}
	 /**
     * 获取当前登录用户的权限
     * @param requestBody	请求体
     */
    @RequestMapping(value = "/getLoginUserRights")
    @ResponseBody
    public Object  getLoginUserRights(@RequestBody Object requestBody) {
    	Subject subject = SecurityUtils.getSubject();
    	Session session = subject.getSession(false);
    	TUser sysUser = (TUser)session.getAttribute("userInfo");
    	Integer userType = sysUser.getUserType();
    	TSysRole sysRole = sysRoleService.selectRoleByRoleType(userType);
    	List<RightResBody> rights = new ArrayList<RightResBody>();
    	if(null==sysRole){
    		return generateResultData(rights);
    	}
    	RightResBody rr = null;
            List<TSysRights> sysRightsList = sysRightsService.selectSysRightsByRoleId(sysRole.getRoleId());
            for(TSysRights sysRight : sysRightsList){
            	rr = new RightResBody();
            	rr.setId(sysRight.getRightId());
            	rr.setpId(sysRight.getParentRightId());
            	rr.setName(sysRight.getRightName());
            	rr.setCode(sysRight.getRightCode());
            	rr.setGrade(sysRight.getRightGrade());
            	rights.add(rr);
            }
        return generateResultData(rights);
    }
}
