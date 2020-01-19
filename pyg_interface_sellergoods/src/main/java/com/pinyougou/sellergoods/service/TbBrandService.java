package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;

import java.util.List;

/**
 * @ClassName: TbBrandService
 * @author: itXiaoKe
 * @date: 2020/1/19 12:20
 * @Description: 操作品牌的接口
 * @Version: 1.0
 */
public interface TbBrandService {
    /**
     * @param :
     * @return java.util.List<com.pinyougou.pojo.TbBrand>
     * @Title: findAll
     * @Description: 查询所有品牌
     * @author: itXiaoKe
     * @date: 2020/1/19 12:20
     */
    List<TbBrand> findAll();
}
