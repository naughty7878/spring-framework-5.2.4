package com.test.ioc.component;

import com.test.ioc.person.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class MyConfgiuration {

//	@Bean("person")
	public Student student() {
		Student student = new Student();
		return student;
	}
}
