package com.vulnverify.web.service;

import com.vulnverify.core.generic.GenericDao;
import com.vulnverify.core.generic.GenericService;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.web.model.TUser;
import com.vulnverify.web.model.requestbody.UserListReqBody;
import com.vulnverify.web.model.view.UserView;

/**
 * 用户接口
 * @author linan
 * @date 2018年4月24日  
 *
 */
public interface UserService extends GenericService<TUser, String>{
	/**
	 * 分页查询
	 * @param page
	 * @param queryInfo
	 */
	void getList(Page<UserView> page, UserListReqBody queryInfo);
	/**
	 * 根据用户名获取用户
	 * @param userAccount
	 * @return
	 */
	TUser getUserByUserAccout(String userAccount);
	/**
	 * 创建用户
	 * @param user
	 */
	void createUser(TUser user)throws Exception;
	/**
	 * 修改用户
	 * @param user
	 */
	void modifyUser(TUser user)throws Exception;
	/**
	 * 删除用户
	 * @param userId
	 */
	void removeUser(String userId);
	TUser selectByEmail(String mailbox);
	TUser authentication(TUser su);
}
