package com.test.propertysource.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"person.properties"})
public class Person {

    @Value("${person.name}")
    private String name;

    @Value("${person.age}")
    private int age;


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +'\'' +
                '}';
    }
}
