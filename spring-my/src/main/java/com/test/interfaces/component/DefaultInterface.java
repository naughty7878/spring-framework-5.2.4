package com.test.interfaces.component;

import org.springframework.context.annotation.Bean;

public interface DefaultInterface {
	@Bean
	default Person person(){
		System.out.println("创建一个Person");
		return new Person();
	}
}
