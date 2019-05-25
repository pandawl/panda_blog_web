package com.wang.server.controller;

import com.wang.server.common.util.ResultCode;
import com.wang.server.common.util.ResultUtils;
import com.wang.server.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wl
 * @Date: 2019-05-25 16:37
 * @Description:
 */
@RestController
@RequestMapping("/panda/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @PostMapping("/list")
    public String getList(){

        return ResultUtils.generateResultStr(ResultCode.SUCCESS,"查询成功", blogService.selectAll());
    }
}
