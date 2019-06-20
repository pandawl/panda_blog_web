package com.wang.demo.sheji.observer;


import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wl
 * @Date: 2019/6/20 10:27
 * @Description:
 */
public class SubscriptionSubject implements Subject {

    //存储动物
    private List<Observer> animals =new ArrayList<Observer>();

    @Override
    public void add(Observer observer) {
        animals.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        animals.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer animal : animals) {
            animal.update(message);
        }
    }
}
