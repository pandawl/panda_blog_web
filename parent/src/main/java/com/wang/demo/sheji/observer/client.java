package com.wang.demo.sheji.observer;

/**
 * @Auther: wl
 * @Date: 2019/6/20 10:39
 * @Description:
 */
public class client {
    public static void main(String[] args) {
        animalObserver observer = new animalObserver("狗子");
        animalObserver observer2 = new animalObserver("猫");
        animalObserver observer3 = new animalObserver("牛");
        animalObserver observer4 = new animalObserver("马");
        animalObserver observer5 = new animalObserver("熊猫");
        SubscriptionSubject subject = new SubscriptionSubject();
        subject.add(observer);
        subject.add(observer2);
        subject.add(observer3);
        subject.add(observer4);
        subject.add(observer5);
        subject.notify("我要吃饭");

    }
}
