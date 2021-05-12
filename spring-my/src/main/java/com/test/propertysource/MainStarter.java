package com.test.propertysource;

import com.test.propertysource.component.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author h__d
 */
public class MainStarter {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

		Person person = context.getBean(Person.class);
		System.out.println(person);
	}
}
