package com.wang.server.controller;

import com.wang.server.common.util.ResultCode;
import com.wang.server.common.util.ResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: wl
 * @Date: 2019/4/28 08:53
 * @Description:
 */
@Controller
@RequestMapping(value = "panda/login")
@ResponseBody
public class LoginController {

    @RequestMapping(value = "")
    private String login(String userName,String password){

        if (null == userName || null == password){
            return ResultUtils.generateResultStr(ResultCode.PARAM_ERROR, "用户名，密码不能为空", null);
        }

        return null;
    }


}
