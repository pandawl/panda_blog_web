package com.panda.admin.controller.system;


import com.panda.PandaResponse;
import com.panda.base.controller.BaseController;
import com.panda.exception.PandaException;
import com.panda.pojo.QueryRequest;
import com.panda.pojo.blog.User;
import com.panda.pojo.blog.UserConfig;
import com.panda.service.RoleService;
import com.panda.service.UserConfigService;
import com.panda.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wl
 * @Date: 2019/4/28 08:53
 * @Description: 用户管理
 */
@Slf4j
@RestController
@RequestMapping(value = "panda/user")
public class UserController extends BaseController {


    private String message;

    @Autowired
    private UserService userService;
    @Autowired
    private UserConfigService userConfigService;
    @Autowired
    private RoleService roleService;

    @GetMapping
    @RequiresPermissions("user:view")
    public PandaResponse userList(QueryRequest queryRequest, User user) {
        return new PandaResponse().data(getDataTable(userService.findUserDetail(user, queryRequest)));
    }

    @PutMapping("/userconfig")
    public void saveUserConfig(UserConfig userConfig) {
        try {
            userConfigService.update(userConfig);
        } catch (Exception e) {
            message = "修改个性化配置失败";
            log.error(message, e);
            throw new PandaException(message);
        }
    }
}
