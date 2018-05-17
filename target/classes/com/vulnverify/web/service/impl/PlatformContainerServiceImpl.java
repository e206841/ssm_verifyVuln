package com.vulnverify.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vulnverify.core.generic.GenericDao;
import com.vulnverify.core.generic.GenericServiceImpl;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.web.dao.TPlatformContainerMapper;
import com.vulnverify.web.model.TPlatformContainer;
import com.vulnverify.web.model.requestbody.PlatformContainerReqBody;
import com.vulnverify.web.model.view.PlatformContainerView;
import com.vulnverify.web.model.view.VulnVerifyView;
import com.vulnverify.web.service.PlatformContainerService;
/**
 * 用户接口实现
 * @author zhangdj
 * @date 2018年4月24日  
 *
 */
@Service
public class PlatformContainerServiceImpl extends GenericServiceImpl<TPlatformContainer, Integer> implements PlatformContainerService{
	@Resource
	private TPlatformContainerMapper  platformContainerMapper ;

	


	public void getList(Page<PlatformContainerView> page, PlatformContainerReqBody queryInfo) {
		List<VulnVerifyView> list = platformContainerMapper.getList(page,queryInfo);
	}

	@Override
	public GenericDao<TPlatformContainer, Integer>  getDao() {

		return platformContainerMapper;	
	}

	@Override
	public TPlatformContainer selectMatch(TPlatformContainer platformContainer) {
		return platformContainerMapper.selectMatch(platformContainer);
	}



	
	
}
