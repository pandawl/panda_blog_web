package com.panda.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.panda.pojo.blog.LoginLog;

public interface LoginLogService extends IService<LoginLog> {

    void saveLoginLog(LoginLog loginLog);
}
