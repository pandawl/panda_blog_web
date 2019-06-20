package com.wang.demo.sheji.strategy.parse.impl;

import com.wang.demo.sheji.strategy.parse.FileParse;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: wl
 * @Date: 2019/6/19 11:08
 * @Description:
 */
@Slf4j
public class FileParseLMImpl implements FileParse {
    @Override
    public void parse() {
        log.info("朗明===对账文件解析成功");
    }
}
