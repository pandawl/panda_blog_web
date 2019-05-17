package com.wang.server.controller;

import com.wang.server.common.util.ResultCode;
import com.wang.server.common.util.ResultUtils;
import com.wang.server.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wl
 * @Date: 2019/5/17 14:32
 * @Description:
 */
@RestController
@RequestMapping("/panda/manage/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping("/list")
    public String getAll(){
        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "查询成功", tagService.selectAll());
    }
}
