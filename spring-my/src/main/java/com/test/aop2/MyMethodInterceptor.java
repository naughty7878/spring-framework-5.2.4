package com.test.aop2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceptor implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object obj = null;
		System.out.println("CustomMethodBeforeAdviceAspect around1 ...");
		obj = invocation.proceed();
		System.out.println("CustomMethodBeforeAdviceAspect around2 ...");
		return obj;
	}
}
