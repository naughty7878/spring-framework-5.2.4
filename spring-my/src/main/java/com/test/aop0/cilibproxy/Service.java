package com.test.aop0.cilibproxy;

public class Service {

    /**
     *  final 方法不能被子类覆盖
     */
    public final void finalMethod() {
        System.out.println("Service.finalMethod 执行了");
    }

    public void publicMethod() {
        System.out.println("Service.publicMethod 执行了");
    }
}