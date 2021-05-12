package com.test.ioc.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 测试@PostConstruct的使用
 */
@Component
public class PersonAPostContruct {

	private String name;

	private String sex;

	public PersonAPostContruct() {
		System.out.println("PersonAPostContruct() Construct Method");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@PostConstruct
	public void init(){
		System.out.println("调用：PersonAPostContruct#init()");
	}

	@PreDestroy
	public void destroy(){
		System.out.println("调用：PersonAPostContruct#destroy()");
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", sex='" + sex + '\'' +
				'}';
	}
}
