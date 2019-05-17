package com.wang.server.controller;

import com.wang.server.common.util.ResultCode;
import com.wang.server.common.util.ResultUtils;
import com.wang.server.service.CategoryService;
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
    public String getAll(){
       return ResultUtils.generateResultStr(ResultCode.SUCCESS, "查询成功", categoryService.selectAll());
    }
}
