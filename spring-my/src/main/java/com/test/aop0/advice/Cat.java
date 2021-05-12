package com.test.aop0.advice;

public class Cat implements Animal {

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

	@Override
	public void go() {
		System.out.println("猫在跑");
	}
}