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
        return tbBrandMapper.findAll();
    }

    @Override
    public PageResult<TbBrand> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<TbBrand> pageReturn = (Page<TbBrand>) tbBrandMapper.findAll();
        return new PageResult<>(pageReturn.getTotal(), pageReturn.getResult());
    }
}
