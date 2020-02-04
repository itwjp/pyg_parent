package com.pinyougou.vo;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: Specification
 * @author: itXiaoKe
 * @date: 2020/2/4 12:54
 * @Description: no description
 * @Version: 1.0
 */
public class Specification implements Serializable {
    private TbSpecification tbSpecification;

    private List<TbSpecificationOption> optionList;

    public Specification() {
    }

    public Specification(TbSpecification tbSpecification, List<TbSpecificationOption> optionList) {
        this.tbSpecification = tbSpecification;
        this.optionList = optionList;
    }

    public TbSpecification getTbSpecification() {
        return tbSpecification;
    }

    public void setTbSpecification(TbSpecification tbSpecification) {
        this.tbSpecification = tbSpecification;
    }

    public List<TbSpecificationOption> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<TbSpecificationOption> optionList) {
        this.optionList = optionList;
    }
}
