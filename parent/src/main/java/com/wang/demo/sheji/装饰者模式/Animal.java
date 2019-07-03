package com.wang.demo.sheji.装饰者模式;

import java.math.BigDecimal;

/**
 * @Auther: wl
 * @Date: 2019/7/1 10:22
 * @Description:
 */
public abstract class Animal {

    String desc = "不知名动物";

    public String getDesc(){
        return desc;
    }

    public abstract BigDecimal cost();
}
