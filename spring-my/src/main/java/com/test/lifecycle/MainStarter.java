package com.test.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainStarter {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		context.start();
		Object mainConfig = context.getBean("mainConfig");
		System.out.println(mainConfig);
		context.close();
	}

}
