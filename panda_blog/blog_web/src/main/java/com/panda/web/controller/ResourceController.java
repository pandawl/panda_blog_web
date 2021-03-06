package com.panda.web.controller;


import com.panda.common.util.ResultCode;
import com.panda.common.util.ResultUtils;
import com.panda.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wl
 * @Date: 2019/5/14 17:41
 * @Description:
 */
@RestController
@RequestMapping("panda/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String getResource() {
        return ResultUtils.generateResultStr(ResultCode.SUCCESS, "查询成功", resourceService.getResource());
    }
}
