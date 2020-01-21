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

    /**
     * @param tbBrand:
     * @return void
     * @Title: insertBrand
     * @Description: 添加品牌
     * @author: itXiaoKe
     * @date: 2020/1/21 13:49
     */
    void insertBrand(TbBrand tbBrand);

    /**
     * @param id:
     * @return com.pinyougou.pojo.TbBrand
     * @Title: findSingleBrand
     * @Description: 根据id查询单个商品
     * @author: itXiaoKe
     * @date: 2020/1/21 14:44
     */
    TbBrand findSingleBrand(long id);

    /**
     * @param tbBrand:
     * @return void
     * @Title: updateBrand
     * @Description: 修改品牌信息
     * @author: itXiaoKe
     * @date: 2020/1/21 16:21
     */
    void updateBrand(TbBrand tbBrand);

    /**
     * @param longs:
     * @return void
     * @Title: deleteBrand
     * @Description: 删除品牌
     * @author: itXiaoKe
     * @date: 2020/1/21 17:13
     */
    void deleteBrand(long[] longs);
}
