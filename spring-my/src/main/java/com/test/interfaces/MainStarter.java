package com.test.interfaces;

import com.test.interfaces.component.DefaultInterface;
import com.test.interfaces.component.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author h__d
 */
public class MainStarter {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

		System.out.println(context.getBean(DefaultInterface.class));
	}
}
