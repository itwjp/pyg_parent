package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.Result;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.TbBrandService;
import com.pinyougou.utils.PageResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/insertBrand")
    public Result insertBrand(@RequestBody TbBrand tbBrand) {
        try {
            tbBrandService.insertBrand(tbBrand);
            return new Result(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加失败");
        }
    }

    @RequestMapping("/findSingleBrand/{id}")
    public TbBrand findSingleBrand(@PathVariable("id") long id) {
        return tbBrandService.findSingleBrand(id);
    }

    @RequestMapping("/updateBrand")
    public Result updateBrand(@RequestBody TbBrand tbBrand) {
        try {
            tbBrandService.updateBrand(tbBrand);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    @RequestMapping("/deleteBrand/{selectIds}")
    public Result deleteBrand(@PathVariable("selectIds") long[] longs) {
        try {
            tbBrandService.deleteBrand(longs);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}
