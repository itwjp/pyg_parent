package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.Result;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.sellergoods.service.TbSpecificationService;
import com.pinyougou.utils.PageResult;
import com.pinyougou.vo.Specification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: TbSpecificationController
 * @author: itXiaoKe
 * @date: 2020/2/4 13:02
 * @Description: no description
 * @Version: 1.0
 */
@RestController
@RequestMapping("/specification")
public class TbSpecificationController {
    @Reference
    private TbSpecificationService tbSpecificationService;

    @RequestMapping("/findAll")
    public List<TbSpecification> findAll() {
        return tbSpecificationService.findAll();
    }

    @RequestMapping("/findPage/{page}/{size}")
    public PageResult<TbSpecification> findPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        return tbSpecificationService.findPage(page, size);
    }

    @RequestMapping("/insertSpecification")
    public Result insertSpecification(@RequestBody Specification specification) {
        try {
            tbSpecificationService.insertSpecification(specification);
            return new Result(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加失败");
        }
    }

    @RequestMapping("/findSingleSpecification/{id}")
    public Specification findSingleSpecification(@PathVariable("id") long id) {
        return tbSpecificationService.findSingleSpecification(id);
    }

    @RequestMapping("/updateSpecification")
    public Result updateSpecification(@RequestBody TbSpecification tbSpecification) {
        try {
            tbSpecificationService.updateSpecification(tbSpecification);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    @RequestMapping("/deleteSpecification/{selectIds}")
    public Result deleteSpecification(@PathVariable("selectIds") long[] longs) {
        try {
            tbSpecificationService.deleteSpecification(longs);
            return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }
}
