package com.vulnverify.core.generic;

import org.springframework.dao.DataAccessException;

/**
 * 所有自定义Dao的顶级接口, 封装常用的增删查改操作,
 * 可以通过Mybatis Generator Maven 插件自动生成Dao,
 * 也可以手动编码,然后继承GenericDao 即可.
 * <p/>
 * Model : 代表数据库中的表 映射的Java对象类型
 * PK :代表对象的主键类型
 *
 * @author linan
 */
public interface GenericDao<Model, PK> {
	
	/**
     * 插入对象
     * @param model 对象
     * @return 插入对象的数量
     */
    int insert(Model model);

    /**
     * 插入对象,值为null的属性不赋值到字段
     * @param model 对象
     * @return 插入对象的数量
     */
    int insertSelective(Model model) throws DataAccessException;
    
    /**
     * 更新对象
     * @param model 对象
     * @return 更新对象的数量
     */
    int updateByPrimaryKey(Model model);

    /**
     * 更新对象,值为null的属性不赋值到字段
     * @param model 对象
     * @return 更新对象的数量
     */
    int updateByPrimaryKeySelective(Model model);

    /**
     * 通过主键, 删除对象
     * @param id 主键
     * @return 删除对象的数量
     */
    int deleteByPrimaryKey(PK id);

    /**
     * 通过主键, 查询对象
     * @param id 主键
     * @return 对象
     */
    Model selectByPrimaryKey(PK id);

}
