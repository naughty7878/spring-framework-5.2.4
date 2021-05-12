package com.test.aop0.jdkproxy;

public class Client {
    public static void main(String[] args) {
        // 1. 构造目标对象
        Cat catTarget = new Cat();

        // 2. 根据目标对象生成代理对象
        JdkDynamicProxy proxy = new JdkDynamicProxy(catTarget);

        // JDK 动态代理是基于接口的，所以只能转换为 Cat 实现的接口 Animal
        Animal catProxy = proxy.getProxy();

        // 调用代理对象的方法
        catProxy.eat();
    }
}