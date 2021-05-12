package com.test.ioc;

import com.test.ioc.component.PersonAPostContruct;
import com.test.ioc.person.Person;
import com.test.ioc.person.PersonFactoryBean;
import com.test.ioc.person.PersonIInitializingBean;
import com.test.ioc.person.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
//@ComponentScan(basePackages = {"com.test.ioc.component"})
public class MainConfig {

//	public MainConfig(){
//		System.out.println("MainConfig() Construct Method");
//	}


	@Bean
	public Person person() {
		Person person = new Person();
		person.setName("张三");
		person.setSex("男");
		return person;
	}

//
//	@Bean
//	public PersonFactoryBean personFactoryBean() {
//		PersonFactoryBean person = new PersonFactoryBean();
//		person.setName("张三");
//		person.setSex("女");
//		return person;
//	}

//	@Bean(initMethod = "initPerson")
//	public PersonIInitializingBean personIInitializingBean() {
//		PersonIInitializingBean person = new PersonIInitializingBean();
//		person.setName("张三");
//		person.setSex("男");
//		return person;
//	}


	// 测试 @Configuration 与 @Bean搭配使用，@Bea修饰的方法只会调用一次
	// @Configuration配置类，被Spring使用来cglib代理了
//	@Bean
//	public Person person() {
//		Person person = new Person();
//		Student student = student();
//		return person;
//	}
//
//	@Bean
//	public Student student() {
//		Student student = new Student();
//		return student;
//	}

//	@Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
//	public PersonIInitializingBean personIInitializingBean() {
//		PersonIInitializingBean person = new PersonIInitializingBean();
//		person.setName("王五");
//		person.setSex("男");
//		return person;
//	}

}
