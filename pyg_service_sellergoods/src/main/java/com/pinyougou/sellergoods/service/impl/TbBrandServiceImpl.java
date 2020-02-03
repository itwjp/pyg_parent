package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.TbBrandService;
import com.pinyougou.utils.PageResult;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: TbBrandServiceImpl
 * @author: itXiaoKe
 * @date: 2020/1/19 12:21
 * @Description: no description
 * @Version: 1.0
 */
@Service
@Transactional
public class TbBrandServiceImpl implements TbBrandService {

    @Resource
    private TbBrandMapper tbBrandMapper;

    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(null);
    }

    @Override
    public PageResult<TbBrand> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<TbBrand> pageReturn = (Page<TbBrand>) tbBrandMapper.selectByExample(null);
        return new PageResult<>(pageReturn.getTotal(), pageReturn.getResult());
    }

    @Override
    public void insertBrand(TbBrand tbBrand) {
        tbBrandMapper.insert(tbBrand);
    }

    @Override
    public TbBrand findSingleBrand(long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateBrand(TbBrand tbBrand) {
        tbBrandMapper.updateByPrimaryKey(tbBrand);
    }

    @Override
    public void deleteBrand(long[] longs) {
        for (long aLong : longs) {
            tbBrandMapper.deleteByPrimaryKey(aLong);
        }
    }
}
