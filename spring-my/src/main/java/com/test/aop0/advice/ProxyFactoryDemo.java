package com.test.aop0.advice;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.cglib.proxy.MethodInterceptor;

public class ProxyFactoryDemo {

	public static void main(String[] args) {
		// 1. 构造目标对象
		Animal catTarget = new Cat();

		// 2. 通过目标对象，构造 ProxyFactory 对象
		ProxyFactory factory = new ProxyFactory(catTarget);

		// 添加一个 Advice (DefaultPointcutAdvisor)
		factory.addAdvice(new MyMethodInterceptor());

		// 新增代码：添加一个 PointcutAdvisor
		MyPointcutAdvisor myPointcutAdvisor = new MyPointcutAdvisor(new MyMethodInterceptor());
		factory.addAdvisor(myPointcutAdvisor);

		// 3. 根据目标对象生成代理对象
		Object proxy = factory.getProxy();

		Animal cat = (Animal) proxy;
		System.out.println(cat.getClass());
		cat.eat();

		System.out.println("---------------------------------------");

		cat.go();
	}


}