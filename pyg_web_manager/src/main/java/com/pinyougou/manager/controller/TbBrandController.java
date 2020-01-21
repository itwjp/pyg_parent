package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.TbBrandService;
import com.pinyougou.utils.PageResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: TbBrandController
 * @author: itXiaoKe
 * @date: 2020/1/19 16:27
 * @Description: no description
 * @Version: 1.0
 */
@RestController
@RequestMapping("/brand")
public class TbBrandController {

    @Reference
    private TbBrandService tbBrandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll() {
        return tbBrandService.findAll();
    }

    @RequestMapping("/findPage/{page}/{size}")
    public PageResult<TbBrand> findPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        return tbBrandService.findPage(page, size);
    }
}
