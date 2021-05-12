package com.test.ioc.person;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

public class PersonIInitializingBean implements InitializingBean, DisposableBean {

	private String name;

	private String sex;

	public String getName() {
		return name;
	}


	public PersonIInitializingBean() {
		System.out.println("PersonIInitializingBean 构造方法....");
	}

	public void initPerson() {
		System.out.println("init方法");
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
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet ....方法");
	}

	public void initMethod() throws Exception {
		System.out.println("initMethod ....方法");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy ....方法");
	}

	public void destroyMethod() throws Exception {
		System.out.println("destroyMethod ....方法");
	}


	@Override
	public String toString() {
		return "PersonIInitializingBean{" +
				"name='" + name + '\'' +
				", sex='" + sex + '\'' +
				'}';
	}


}
