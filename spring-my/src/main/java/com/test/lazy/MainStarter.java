package com.test.lazy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainStarter {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		System.out.println("-----");
		Person person = (Person) context.getBean(Person.class);
		System.out.println(person);
	}
}
