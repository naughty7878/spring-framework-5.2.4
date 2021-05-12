package com.test.aop0.jdkproxy;

public class Cat implements Animal {

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}