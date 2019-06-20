package com.wang.demo.sheji.observer;

/**
 * @Auther: wl
 * @Date: 2019/6/20 10:33
 * @Description:
 */
public class animalObserver implements Observer{

   private String name;

   public animalObserver(String name){
        this.name = name;
   }

    @Override
    public void update(String mes) {
        System.out.println(name+"=="+ mes);
    }
}
