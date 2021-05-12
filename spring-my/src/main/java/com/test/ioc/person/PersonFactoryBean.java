package com.test.ioc.person;

import com.test.ioc.person.Person;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * FactoryBean接口的作用实例类
 */

public class PersonFactoryBean implements FactoryBean<Person> {

	private String name;

	private String sex;

	public String getName() {
		return name;
	}

	public PersonFactoryBean() {
		System.out.println("PersonFactoryBean() Construct Method");
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

	@Override
	public String toString() {
		return "PersonFactoryBean{" +
				"name='" + name + '\'' +
				", sex='" + sex + '\'' +
				'}';
	}

	@Override
	public Person getObject() throws Exception {
		Person person = new Person();
		person.setName("李四");
		person.setSex("男");
		return person;
	}

	@Override
	public Class<?> getObjectType() {
		return Person.class;
	}
}
