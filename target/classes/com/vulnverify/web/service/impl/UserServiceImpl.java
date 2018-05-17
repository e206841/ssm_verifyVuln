package com.vulnverify.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vulnverify.core.generic.GenericDao;
import com.vulnverify.core.generic.GenericServiceImpl;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.core.utils.ApplicationUtils;
import com.vulnverify.web.dao.TUserMapper;
import com.vulnverify.web.enums.user.UserType;
import com.vulnverify.web.model.TUser;
import com.vulnverify.web.model.requestbody.UserListReqBody;
import com.vulnverify.web.model.view.UserView;
import com.vulnverify.web.service.UserService;
/**
 * 用户接口实现
 * @author linan
 * @date 2018年4月24日  
 *
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<TUser, String> implements UserService{
	@Resource
	private TUserMapper userMapper;

	@Override
	public GenericDao<TUser, String> getDao() {
		return userMapper;
	}
	/**
	 * 分页查询
	 */
	@Override
	public void getList(Page<UserView> page, UserListReqBody queryInfo) {
		List<UserView> list = userMapper.getList(page,queryInfo);
		for (UserView user : list) {
			String userType = user.getUserType();
			for (UserType type : UserType.values()) {
				if(userType.equals(type.getIndex().toString())){
					user.setUserTypeName(type.getName());
				}
			}
			String updateUser = user.getUpdateUser();
			if(null!=updateUser){
				TUser selectByPrimaryKey = userMapper.selectByPrimaryKey(updateUser);
				if(null!=selectByPrimaryKey){
					user.setUpdateUser(selectByPrimaryKey.getUserName());
				}
			}
		}
	}
	/**
	 * 根据用户名获取用户
	 */
	@Override
	public TUser getUserByUserAccout(String userAccount) {
		return userMapper.getByUserAccout(userAccount);
	}
	/**
	 * 创建用户
	 * @throws Exception 
	 */
	@Override
	public void createUser(TUser user) throws Exception {
		//密码加密
		String shaPassword = ApplicationUtils.sha256Hex(user.getPassword());
		user.setPassword(shaPassword);
		userMapper.insertSelective(user);
	}
	/**
	 *修改用户
	 * @throws Exception 
	 */
	@Override
	public void modifyUser(TUser user) throws Exception {
		userMapper.updateByPrimaryKeySelective(user);
	}
	/**
	 * 删除用户
	 */
	@Override
	public void removeUser(String userId) {
		userMapper.deleteByPrimaryKey(userId);
	}
	@Override
	public TUser selectByEmail(String mailbox) {
		return userMapper.selectByEmail(mailbox);
	}
	@Override
	public TUser authentication(TUser user) {
		 return userMapper.authentication(user);
	}

}
