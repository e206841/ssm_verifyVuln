package com.vulnverify.web.service;

import java.util.List;
import java.util.Map;

import com.vulnverify.core.generic.GenericService;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.web.model.TImage;
import com.vulnverify.web.model.requestbody.ImageAddReqBody;
import com.vulnverify.web.model.requestbody.ImageListReqBody;
import com.vulnverify.web.model.view.ImageView;

public interface ImageService extends GenericService<TImage, Integer>{
	/**
	 * 分页查询
	 */
	void getList(Page<ImageView> page, ImageListReqBody req);
	
	/**
	 * 查询已经存在
	 */
	int getCount(Map<String, String> req);
	
	/**
	 * 根据状态查询
	 */
	int getCountByState(Map<String, String> req);
	
	/**
	 * 根据UUID更新
	 */
	int updateByUUID(TImage image);
	
    /**
     * 动态匹配查询（UUID不为空）
     * @param page
     * @param queryInfo
     */	
	TImage selectMatch(TImage image);
    /**
     * 查询全部镜像
     * @param page
     * @param queryInfo
     */	
	List<TImage> selectAll();
}
