package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.utils.PageResult;
import com.pinyougou.vo.Specification;

import java.util.List;

/**
 * @ClassName: TbSpecificationService
 * @author: itXiaoKe
 * @date: 2020/2/4 13:04
 * @Description: no description
 * @Version: 1.0
 */
public interface TbSpecificationService {
    /**
     * @param :
     * @return java.util.List<com.pinyougou.pojo.TbSpecification>
     * @Title: findAll
     * @Description: 查询所有品牌
     * @author: itXiaoKe
     * @date: 2020/1/19 12:20
     */
    List<TbSpecification> findAll();

    /**
     * @param page:
     * @param size:
     * @return java.util.List<com.pinyougou.pojo.TbSpecification>
     * @Title: findPage
     * @Description: 分页查询品牌
     * @author: itXiaoKe
     * @date: 2020/1/21 10:09
     */
    PageResult<TbSpecification> findPage(int page, int size);

    /**
     * @param specification:
     * @return void
     * @Title: insertSpecification
     * @Description: 添加品牌
     * @author: itXiaoKe
     * @date: 2020/1/21 13:49
     */
    void insertSpecification(Specification specification);

    /**
     * @param id:
     * @return com.pinyougou.pojo.TbSpecification
     * @Title: findSingleSpecification
     * @Description: 根据id查询单个商品
     * @author: itXiaoKe
     * @date: 2020/1/21 14:44
     */
    Specification findSingleSpecification(long id);

    /**
     * @param tbSpecification:
     * @return void
     * @Title: updateSpecification
     * @Description: 修改品牌信息
     * @author: itXiaoKe
     * @date: 2020/1/21 16:21
     */
    void updateSpecification(TbSpecification tbSpecification);

    /**
     * @param longs:
     * @return void
     * @Title: deleteSpecification
     * @Description: 删除品牌
     * @author: itXiaoKe
     * @date: 2020/1/21 17:13
     */
    void deleteSpecification(long[] longs);
}
