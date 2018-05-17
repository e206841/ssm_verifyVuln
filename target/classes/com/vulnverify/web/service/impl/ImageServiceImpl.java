
package com.vulnverify.web.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.vulnverify.core.generic.GenericDao;
import com.vulnverify.core.generic.GenericServiceImpl;
import com.vulnverify.core.orm.mybatis.Page;
import com.vulnverify.web.dao.TImageMapper;
import com.vulnverify.web.model.TImage;
import com.vulnverify.web.model.requestbody.ImageAddReqBody;
import com.vulnverify.web.model.requestbody.ImageListReqBody;
import com.vulnverify.web.model.view.ImageView;
import com.vulnverify.web.service.ImageService;

/**
 * @author luoxiao
 *
 */
@Component
public class ImageServiceImpl extends GenericServiceImpl<TImage, Integer> implements ImageService{
	@Resource
	private TImageMapper imageMapper;

	@Override
	public GenericDao<TImage, Integer> getDao() {
		return imageMapper;
	}
	/**
	 * 分页查询
	 */
	@Override
	public void getList(Page<ImageView> page, ImageListReqBody queryInfo) {
		List<ImageView> list = imageMapper.getList(page,queryInfo);
		page.setResult(list);
	}
	
	@Override
	public int getCount(Map<String, String> req) {
		return imageMapper.getCount(req);
	}

	@Override
	public int getCountByState(Map<String, String> req) {
		return imageMapper.getCountByState(req);
	}
	
	@Override
	public int updateByUUID(TImage image) {
		return imageMapper.updateByUUID(image);
	}
    /**
     * 动态匹配查询（UUID不为空）
     * @param page
     * @param queryInfo
     */	
	@Override
	public TImage selectMatch(TImage image) {
		return imageMapper.selectMatch(image);
	}
    /**
     * 查询全部镜像
     * @param page
     * @param queryInfo
     */	
	@Override
	public List<TImage> selectAll(){
		return imageMapper.selectAll();
	}
}
