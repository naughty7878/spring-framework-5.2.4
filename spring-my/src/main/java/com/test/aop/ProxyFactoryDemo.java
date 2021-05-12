package com.test.aop;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.interceptor.ExposeInvocationInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactoryDemo {

    public static void main(String[] args) {
        // 1. 构造目标对象
        Cat catTarget = new Cat();

        // 2. 通过目标对象，构造 ProxyFactory 对象
        ProxyFactory factory = new ProxyFactory(catTarget);

        // 添加一个方法拦截器
        factory.addAdvice(new MyMethodInterceptor());

        // 3. 根据目标对象生成代理对象
        Object proxy = factory.getProxy();

        Animal cat = (Animal) proxy;
        cat.eat();
    }

	interface Animal {
		void eat();
	}

	static class Cat implements Animal{
		@Override
		public void eat() {
			System.out.println("猫吃鱼");
		}
	}

	private static class MyMethodInterceptor implements MethodInterceptor {
		@Override
		public Object invoke(MethodInvocation invocation) throws Throwable {
			System.out.println("代理方法" );
			return invocation.proceed();
		}
	}
}