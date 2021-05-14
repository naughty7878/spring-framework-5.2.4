package com.test.aop0.callchain;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class JdkDynamicProxy2 implements InvocationHandler {

    /**
     * 目标对象（也被称为被代理对象）
     */
    private Object target;

    /**
     * 责任链 HeadHandler，仅用来开始责任链执行，不对方法进行增强处理
     */
    private AbstractHandler.HeadHandler headHandler;

	public JdkDynamicProxy2() {
	}

	public JdkDynamicProxy2(Object target, AbstractHandler.HeadHandler headHandler) {
		this.target = target;
		this.headHandler = headHandler;
	}

	@Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        TargetMethod targetMethod = new TargetMethod();
        targetMethod.setTarget(target);
        targetMethod.setMethod(method);
        targetMethod.setArgs(args);

        return headHandler.proceed(targetMethod);
    }

    /**
     * 获取被代理接口实例对象
     *
     *      通过 Proxy.newProxyInstance 可以获得一个代理对象，它实现了 target.getClass().getInterfaces() 接口
     *
     * @param <T>
     * @return
     */
    public <T> Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }
}