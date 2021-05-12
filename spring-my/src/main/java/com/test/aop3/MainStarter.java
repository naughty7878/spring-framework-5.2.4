package com.test.aop3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainStarter {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		Target target = context.getBean(Target.class);
		target.targetMethod();
	}
}
