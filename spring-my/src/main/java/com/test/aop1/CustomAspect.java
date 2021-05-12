package com.test.aop1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomAspect {

	// 切点
	private final String POINT_CUT = "execution(* com.test.aop1.Target*.*(..))";

	// 命名切点
	@Pointcut(POINT_CUT)
	public void pointCut(){}

	// 在切点方法之前执行
	@Before(value="pointCut()")
	public void before() {
		System.out.println("CustomMethodBeforeAdviceAspect before ...");
	}

	// 切点方法返回后执行
	@AfterReturning(value = "pointCut()",returning = "result")
	public void afterReturning() {
		System.out.println("CustomMethodBeforeAdviceAspect afterReturning ...");
	}

	// 切点方法抛异常执行
	@AfterThrowing(value = "pointCut()",throwing = "exception")
	public void afterThrowing() {
		System.out.println("CustomMethodBeforeAdviceAspect afterThrowing ...");
	}

	// 在切点方法之后执行
	@After(value="pointCut()")
	public void after() {
		System.out.println("CustomMethodBeforeAdviceAspect after ...");
	}

	// 属于环绕增强，能控制切点执行前，执行后，，用这个注解后，程序抛异常，会影响@AfterThrowing这个注解
	@Around(value="pointCut()")
		public Object around(ProceedingJoinPoint pjp) throws Throwable {

		Object obj = null;
		System.out.println("CustomMethodBeforeAdviceAspect around1 ...");
		obj = pjp.proceed();
		System.out.println("CustomMethodBeforeAdviceAspect around2 ...");

		return obj;
	}


	public void say() {

		System.out.println("hello world");
	}

}
