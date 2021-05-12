package com.test.importresource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author h__d
 */
public class MainStarter {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

		Person person = (Person) context.getBean(Person.class);
		System.out.println(person);
	}
}
