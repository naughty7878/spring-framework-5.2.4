package com.test.importt;

import com.test.importt.component.Student;
import com.test.importt.service.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainStarter {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

		Person person = (Person) context.getBean(Person.class);
		System.out.println(person);
//		System.out.println(context.getBean("mainConfig"));
//		System.out.println(context.getBean(Student.class));
//		System.out.println(context.getBean("com.test.importt.component.Student"));
//		System.out.println(context.getBean(HelloService.class));
//		System.out.println(context.getBean("com.test.importt.component.Student"));
//
	}
}
