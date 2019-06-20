package com.wang.demo.sheji.strategy.check.impl;

import com.wang.demo.sheji.strategy.check.FileCheck;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: wl
 * @Date: 2019/6/19 11:08
 * @Description:
 */
@Slf4j
public class FileCheckZYmpl implements FileCheck {

    @Override
    public void fileCheck() {
        log.info("卓越===对账成功");
    }
}
