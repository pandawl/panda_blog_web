package com.wang.demo.sheji.observer;



/**
 * @Auther: wl
 * @Date: 2019/6/20 10:28
 * @Description: 抽象主题
 */
public interface Subject {

    /**添加订阅者**/
    void add(Observer observer);
    /**移除订阅者**/
    void remove(Observer observer);
    /**通知订阅者**/
    void notify(String message);
}
