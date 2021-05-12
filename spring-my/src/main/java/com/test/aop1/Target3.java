package com.test.aop1;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;

//public class Target {
public class Target3 implements TargetInterface {


	/**
	 * AopContext.currentProxy(); 获取线程中的代理对象，
	 * 需要@EnableAspectJAutoProxy(exposeProxy = true)
	 */
	@Override
	public void targetMethod() {
		System.out.println("---Target#targetMethod()---");
		Object o = AopContext.currentProxy();
		if(o instanceof TargetInterface) {
			// 此处能获得代理，继续调用内部方法
			// 调用内部方法也会被拦截
			TargetInterface proxy = (TargetInterface)o;
			proxy.targetMethod2();
		}
	}

	@Override
	public void targetMethod2() {
		System.out.println("---Target#targetMethod2()---");
	}
}
