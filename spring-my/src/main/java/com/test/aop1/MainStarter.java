package com.test.aop1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainStarter {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		TargetInterface target = (TargetInterface) context.getBean("target");
		target.targetMethod();
		System.out.println(target.toString());
	}
}
