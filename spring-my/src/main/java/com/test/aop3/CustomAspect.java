package com.test.aop3;

import org.aspectj.lang.ProceedingJoinPoint;

public class CustomAspect {

	public void before() {
		System.out.println("CustomMethodBeforeAdviceAspect before ...");
	}

	public void afterReturning() {
		System.out.println("CustomMethodBeforeAdviceAspect afterReturning ...");
	}

	public void afterThrowing() {
		System.out.println("CustomMethodBeforeAdviceAspect afterThrowing ...");
	}

	public void after() {
		System.out.println("CustomMethodBeforeAdviceAspect after ...");
	}

	public Object around(ProceedingJoinPoint pjp) throws Throwable {

		Object obj = null;
		System.out.println("CustomMethodBeforeAdviceAspect around1 ...");
		obj = pjp.proceed();
		System.out.println("CustomMethodBeforeAdviceAspect around2 ...");

		return obj;
	}

	public Object aroundInit(ProceedingJoinPoint pjp, String bizName, int times) throws Throwable {
		System.out.println("CustomMethodBeforeAdviceAspect aroundInit: " + bizName + "    ---    " + times);
		Object obj = null;
		System.out.println("CustomMethodBeforeAdviceAspect around1 ...");
		obj = pjp.proceed();
		System.out.println("CustomMethodBeforeAdviceAspect around2 ...");

		return obj;
	}
}
