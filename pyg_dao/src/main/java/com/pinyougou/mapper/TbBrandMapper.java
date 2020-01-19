package com.pinyougou.mapper;

import com.pinyougou.pojo.TbBrand;

import java.util.List;

/**
 * @ClassName: TbBrandMapper
 * @author: itXiaoKe
 * @date: 2020/1/19 11:37
 * @Description: 操作品牌的接口
 * @Version: 1.0
 */
public interface TbBrandMapper {
    /**
     * @param : 
     * @return java.util.List<com.pinyougou.pojo.TbBrand>
     * @Title: findAll
     * @Description: 查询所有品牌
     * @author: itXiaoKe
     * @date: 2020/1/19 11:39
     */
    List<TbBrand> findAll();
}