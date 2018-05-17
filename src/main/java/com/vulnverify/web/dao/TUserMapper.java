package com.vulnverify.web.dao;

import java.util.List;

import com.vulnverify.core.generic.GenericDao;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.web.model.TUser;
import com.vulnverify.web.model.requestbody.UserListReqBody;
import com.vulnverify.web.model.view.UserView;

public interface TUserMapper extends GenericDao<TUser, String>{

    /**
     * 分页查询
     * @param page
     * @param queryInfo
     */
	List<UserView> getList(Page<UserView> page, UserListReqBody queryInfo);
	/**
	 * 根据账户获取用户
	 * @param userAccount
	 * @return
	 */
	TUser getByUserAccout(String userAccount);
	/**
	 * 根据邮箱查询用户
	 * @param mailbox
	 * @return
	 */
	TUser selectByEmail(String mailbox);
	
	TUser authentication(TUser user);
}