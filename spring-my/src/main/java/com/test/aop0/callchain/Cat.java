package com.test.aop0.callchain;

public class Cat implements com.test.aop0.callchain.Animal {

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}