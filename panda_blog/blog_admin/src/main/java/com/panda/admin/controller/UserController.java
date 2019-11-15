package com.panda.admin.controller;


import com.panda.common.util.ResultCode;
import com.panda.common.util.ResultUtils;
import com.panda.pojo.blog.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: wl
 * @Date: 2019/4/28 08:53
 * @Description: 用户管理
 */
@Controller
@RequestMapping(value = "panda/user")
public class UserController {

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(){
      return  ResultUtils.generateResultStr(ResultCode.SUCCESS, "操作成功", null);
    }

    @ResponseBody
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public String getUser(String id){
    User user = new User();

      return  ResultUtils.generateResultStr(ResultCode.SUCCESS, "操作成功", user);
    }
}
