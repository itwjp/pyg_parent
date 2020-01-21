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

    /**
     * @param tbBrand:
     * @return void
     * @Title: insertBrand
     * @Description: 添加品牌
     * @author: itXiaoKe
     * @date: 2020/1/21 13:43
     */
    void insertBrand(TbBrand tbBrand);

    /**
     * @param id:
     * @return com.pinyougou.pojo.TbBrand
     * @Title: findSingleBrand
     * @Description: 根据id查询单个商品
     * @author: itXiaoKe
     * @date: 2020/1/21 15:04
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
}
