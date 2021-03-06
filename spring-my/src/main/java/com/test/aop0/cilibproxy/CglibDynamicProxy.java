package com.test.aop0.cilibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDynamicProxy implements MethodInterceptor {

    /**
     * 目标对象（也被称为被代理对象）
     */
    private Object target;

    public CglibDynamicProxy(Object target) {
        this.target = target;
    }
    /**
     *
     * @param obj       CGLIB 生成的代理对象
     * @param method    被代理对象方法
     * @param args      方法入参
     * @param proxy     方法代理
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("CglibDynamicProxy intercept 方法执行前-------------------------------");

        System.out.println("obj = " + obj.getClass());
        System.out.println("method = " + method);
        System.out.println("proxy = " + proxy);

        Object object = proxy.invoke(target, args);
        System.out.println("CglibDynamicProxy intercept 方法执行后-------------------------------");
        return object;
    }

    /**
     * 获取被代理接口实例对象
     * 
     * 通过 enhancer.create 可以获得一个代理对象，它继承了 target.getClass() 类
     *
     * @param <T>
     * @return
     */
    public <T> Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
}