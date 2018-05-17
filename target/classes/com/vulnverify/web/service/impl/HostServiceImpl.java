package com.vulnverify.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vulnverify.core.generic.GenericDao;
import com.vulnverify.core.generic.GenericServiceImpl;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.web.dao.THostMapper;
import com.vulnverify.web.model.THost;
import com.vulnverify.web.model.requestbody.HostListReqBody;
import com.vulnverify.web.model.view.HostView;
import com.vulnverify.web.service.HostService;

/**
 * 设备接口实现
 * 
 * @author lihongxian
 * @date 2018年4月26日
 * 
 */
@Service
public class HostServiceImpl extends GenericServiceImpl<THost, Integer> implements HostService{
	@Resource
	private THostMapper hostMapper;

	@Override
	public GenericDao<THost, Integer> getDao() {
		return hostMapper;
	}
	/**
	 * 分页查询
	 */
	@Override
	public void getList(Page<HostView> page, HostListReqBody queryInfo) {
		List<HostView> list = hostMapper.getList(page,queryInfo);
		System.out.println(list.size());
		page.setResult(list);
	}

    /**
     * 动态匹配查询（UUID不为空）
     * @param page
     * @param queryInfo
     */	
	public THost selectMatch(THost host) {
		return hostMapper.selectMatch(host);
	}
	
	@Override
	public THost selectByUuid(String hostMachineUuid) {
		return hostMapper.selectByUuid(hostMachineUuid);
	}

}
