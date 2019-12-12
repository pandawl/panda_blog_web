package com.panda.web.controller;

import com.panda.common.util.ResultCode;
import com.panda.common.util.ResultUtils;
import com.panda.pojo.blog.Category;
import com.panda.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wl
 * @Date: 2019/5/17 12:01
 * @Description:
 */
@RestController
@RequestMapping("/panda/manage/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/list")
    public String getAll(String search) {
        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "查询成功", categoryService.selectAll(search));
    }

    /**
     * 根据id查询
     **/
    @PostMapping("/select")
    public String selete(Integer id) {
        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "查询成功", categoryService.selectByPrimaryKey(id));
    }

    /**
     * 新增
     **/
    @PostMapping("/add")
    public String add(Category category) {
        int count = categoryService.insert(category);
        if (-1 == count) {
            return ResultUtils.resultFail(ResultCode.PARAM_ERROR, "该名称重复");
        }
        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "新增成功", null);
    }

    /**
     * 删除
     **/
    @PostMapping("/delete")
    public String deleteTag(Integer id) {
        if (null == id) {
            ResultUtils.resultFail(ResultCode.PARAM_ERROR, "id不能为空");
        }
        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "删除成功", categoryService.deleteByPrimaryKey(id));
    }

    /**
     * 修改
     **/
    @PostMapping("/update")
    public String update(Category category) {
        if (null == category || null == category.getCategoryName() || "".equals(category.getCategoryName().trim()) || null == category.getId()) {
            ResultUtils.resultFail(ResultCode.PARAM_ERROR, "参数异常");
        }

        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "新增成功", categoryService.updateByPrimaryKey(category));
    }

}
