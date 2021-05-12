package com.test.interfaces.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//@Component
public class Person {

    private String name;

    private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +'\'' +
                '}';
    }
}
