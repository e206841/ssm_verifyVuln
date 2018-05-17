package com.vulnverify.init;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.junit.Test;
import org.springframework.aop.ThrowsAdvice;

import com.vulnverify.core.utils.ApplicationUtils;
import com.vulnverify.core.utils.DateUtil;
import com.vulnverify.web.constant.Constant;
import com.vulnverify.web.controller.TestBase;
import com.vulnverify.web.dao.TSysRightsMapper;
import com.vulnverify.web.dao.TSysRoleMapper;
import com.vulnverify.web.dao.TSysRoleRightsMapper;
import com.vulnverify.web.dao.TUserMapper;
import com.vulnverify.web.enums.user.UserType;
import com.vulnverify.web.model.TSysRights;
import com.vulnverify.web.model.TSysRole;
import com.vulnverify.web.model.TSysRoleRights;
import com.vulnverify.web.model.TUser;

/**
 * 初始化数据库
 * @author linan
 * @date 2018年5月14日  
 *
 */
public class InitDb extends TestBase{
	
	@Resource
	private TUserMapper sysUserMapper;
	@Resource
	private TSysRoleMapper sysRoleMapper;
	@Resource
	private TSysRightsMapper sysRightsMapper;
	@Resource
	private TSysRoleRightsMapper sysRoleRightsMapper;
	
	private Date createDate = new Date();
	//环境管理人员
	private TUser sysadminUser;
	//环境管理人员角色
	private TSysRole sysadminRole;
	//漏洞验证人员角色
	private TSysRole vulnVerifyRole;
	@Test
	public void init(){
    	try {
    		//初始化环境管理人员
    		createSysAdminUser();
    		//初始化环境管理人员角色
    		createSysadminRole();
    		//初始化漏洞验证人员角色
    		createVulnVerifyRole();
    		URL classpath = InitDb.class.getResource("/") ;
    		
    		ObjectMapper om = new ObjectMapper();
    		JavaType jt = om.getTypeFactory().constructParametricType(List.class,RightNode.class);
        	String filePath = classpath.getPath()+"right_type_vulnverify.json";
			List<RightNode> rnList = om.readValue(new File(filePath), jt);
			List<TSysRights> srList = new ArrayList<TSysRights>();
			createSysRights(rnList,srList,0);
			createRoleRights(srList,vulnVerifyRole);
			
			filePath = classpath.getPath()+"right_type_sysadmin.json";
			rnList = om.readValue(new File(filePath), jt);
			srList = new ArrayList<TSysRights>();
			createSysRights(rnList,srList,0);
			createRoleRights(srList,sysadminRole);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 角色 权限关联
	 * @param srList
	 * @param sysadminRole
	 */
	private void createRoleRights(List<TSysRights> srList,TSysRole role){
		TSysRoleRights srr = null;
		for(TSysRights sr : srList){
			srr = sysRoleRightsMapper.selectByRoleIdAndRightId(role.getRoleId(),
					sr.getRightId());
			if(srr == null){
				srr = new TSysRoleRights();
				srr.setCreateDate(createDate);
				srr.setCreateUserid(sysadminUser.getUserId());
				srr.setRightId(sr.getRightId());
				srr.setRoleId(role.getRoleId());
				sysRoleRightsMapper.insertSelective(srr);
			}
		}
	}
	/**
	 * 创建漏洞验证人员角色
	 */
	private void createVulnVerifyRole(){
		vulnVerifyRole = sysRoleMapper.selectRoleByRoleType(UserType.VULN_VERIFY.getIndex());
		if(vulnVerifyRole == null){
			vulnVerifyRole = new TSysRole();
			vulnVerifyRole.setCreateDate(createDate);
			vulnVerifyRole.setCreateUserid(sysadminUser.getUserId());
			vulnVerifyRole.setIsSys(1+"");
			vulnVerifyRole.setRoleDesc("漏洞验证员");
			vulnVerifyRole.setRoleName("漏洞验证员");
			vulnVerifyRole.setRoleType(UserType.VULN_VERIFY.getIndex());
			vulnVerifyRole.setUpdateDate(createDate);
			vulnVerifyRole.setUpdateUserid(sysadminUser.getUserId());
			sysRoleMapper.insertSelective(vulnVerifyRole);
		}
	}
	/**
	 * 创建环境管理人员角色
	 */
	private void createSysadminRole(){
		sysadminRole = sysRoleMapper.selectRoleByRoleType(UserType.SYS_MANAGER.getIndex());
		if(sysadminRole == null){
			sysadminRole = new TSysRole();
			sysadminRole.setCreateDate(createDate);
			sysadminRole.setCreateUserid(sysadminUser.getUserId());
			sysadminRole.setIsSys(1+"");
			sysadminRole.setRoleDesc("环境管理员");
			sysadminRole.setRoleName("环境管理员");
			sysadminRole.setRoleType(UserType.SYS_MANAGER.getIndex());
			sysadminRole.setUpdateDate(createDate);
			sysadminRole.setUpdateUserid(sysadminUser.getUserId());
			sysRoleMapper.insertSelective(sysadminRole);
		}
	}
	
	/**
	 * 初始化环境管理员
	 */
	private void createSysAdminUser(){
		sysadminUser = sysUserMapper.getByUserAccout("sysadmin");
		if(sysadminUser == null){
			sysadminUser = new TUser();
			sysadminUser.setCreateTime(createDate);
			sysadminUser.setCreateUser("1");
			sysadminUser.setMailbox("123@163.com");
			sysadminUser.setPassword(ApplicationUtils.sha256Hex("123123"));
			sysadminUser.setStatus(Constant.USER_STATE_ABLE);
			sysadminUser.setTelephone("18701020304");
			sysadminUser.setUpdateTime(createDate);
			sysadminUser.setUpdateUser("1");
			sysadminUser.setUserAccount("sysadmin");
			sysadminUser.setUserName("环境管理人员");
			sysadminUser.setUserType(UserType.SYS_MANAGER.getIndex());
			sysUserMapper.insertSelective(sysadminUser);
		}
	}
	/**
	 * 权限表数据
	 * @param rnList
	 * @param osrList
	 * @param parentId
	 */
	private void createSysRights(List<RightNode> rnList,List<TSysRights> osrList,long parentId){
		TSysRights sr = null;
		for(RightNode rn : rnList){
			
			sr = sysRightsMapper.selectByRightCode(rn.getRightCode());
			if(sr == null){
				sr = new TSysRights();
				sr.setRightType(rn.getRightType());
				sr.setRightName(rn.getRightName());
				sr.setRightCode(rn.getRightCode());
				sr.setSort(rn.getSort());
				sr.setRightGrade(rn.getRightGrade());
				sr.setCreateDate(createDate);
				sr.setParentRightId(parentId);
				sysRightsMapper.insertSelective(sr);
			}
			osrList.add(sr);
			if(rn.getChildren() != null && rn.getChildren().size() > 0){
				System.out.println(rn.getRightCode());
				List<RightNode> children = rn.getChildren();
				Integer rightId = sr.getRightId();
				createSysRights(rn.getChildren(),osrList,sr.getRightId());
			}
		}
	}
}
