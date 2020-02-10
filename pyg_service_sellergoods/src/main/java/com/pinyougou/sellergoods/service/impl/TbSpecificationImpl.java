package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.mapper.TbSpecificationOptionMapper;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.pojo.TbSpecificationOptionExample;
import com.pinyougou.sellergoods.service.TbSpecificationService;
import com.pinyougou.utils.PageResult;
import com.pinyougou.vo.Specification;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: TbSpecificationImpl
 * @author: itXiaoKe
 * @date: 2020/2/4 13:06
 * @Description: no description
 * @Version: 1.0
 */
@Service
@Transactional
public class TbSpecificationImpl implements TbSpecificationService {
    @Resource
    private TbSpecificationMapper tbSpecificationMapper;
    @Resource
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;

    @Override
    public List<TbSpecification> findAll() {
        return tbSpecificationMapper.selectByExample(null);
    }

    @Override
    public PageResult<TbSpecification> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<TbSpecification> pageReturn = (Page<TbSpecification>) tbSpecificationMapper.selectByExample(null);
        return new PageResult<>(pageReturn.getTotal(), pageReturn.getResult());
    }

    @Override
    public void insertSpecification(Specification specification) {
        TbSpecification tbSpecification = specification.getTbSpecification();
        List<TbSpecificationOption> optionList = specification.getOptionList();
        // 规格主表的主键
        Long id = tbSpecification.getId();
        if (null == id) {
            // id 为空，执行插入
            // 保存规格主表数据，并返回主键 id
            tbSpecificationMapper.insert(tbSpecification);
            // 将主键设置到规格从表中，保存规格从表数据
            for (TbSpecificationOption tbSpecificationOption : optionList) {
                tbSpecificationOption.setSpecId(tbSpecification.getId());
                tbSpecificationOptionMapper.insert(tbSpecificationOption);
            }
        } else {
            // id 不为空，执行修改
            // 修改主表
            tbSpecificationMapper.updateByPrimaryKey(tbSpecification);
            // 修改从表，从表修改的逻辑，先删除，后添加
            TbSpecificationOptionExample example = new TbSpecificationOptionExample();
            TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
            criteria.andSpecIdEqualTo(id);
            tbSpecificationOptionMapper.deleteByExample(example);

            for (TbSpecificationOption tbSpecificationOption : optionList) {
                tbSpecificationOption.setSpecId(id);
                tbSpecificationOptionMapper.insert(tbSpecificationOption);
            }
        }
    }

    @Override
    public Specification findSingleSpecification(long id) {
        TbSpecification tbSpecification = tbSpecificationMapper.selectByPrimaryKey(id);
        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(id);
        List<TbSpecificationOption> optionList = tbSpecificationOptionMapper.selectByExample(example);
        return new Specification(tbSpecification, optionList);
    }

    @Override
    public void updateSpecification(TbSpecification tbSpecification) {
        tbSpecificationMapper.updateByPrimaryKey(tbSpecification);
    }

    @Override
    public void deleteSpecification(long[] longs) {
        for (long aLong : longs) {
            TbSpecificationOptionExample optionExample = new TbSpecificationOptionExample();
            TbSpecificationOptionExample.Criteria criteria = optionExample.createCriteria();
            criteria.andSpecIdEqualTo(aLong);
            // 删除从表数据
            tbSpecificationOptionMapper.deleteByExample(optionExample);
            // 删除主表数据
            tbSpecificationMapper.deleteByPrimaryKey(aLong);
        }
    }
}
