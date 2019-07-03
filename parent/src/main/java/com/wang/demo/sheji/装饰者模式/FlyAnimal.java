package com.wang.demo.sheji.装饰者模式;

import java.math.BigDecimal;

/**
 * @Auther: wl
 * @Date: 2019/7/1 10:24
 * @Description:
 */
public abstract class FlyAnimal extends Animal {

    public abstract String setDesc();
    @Override
    public BigDecimal cost() {
        return null;

    }
}
