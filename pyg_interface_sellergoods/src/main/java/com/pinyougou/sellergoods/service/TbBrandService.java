package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.utils.PageResult;

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

    /**
     * @param page:
     * @param size:
     * @return java.util.List<com.pinyougou.pojo.TbBrand>
     * @Title: findPage
     * @Description: 分页查询品牌
     * @author: itXiaoKe
     * @date: 2020/1/21 10:09
     */
    PageResult<TbBrand> findPage(int page, int size);
}
