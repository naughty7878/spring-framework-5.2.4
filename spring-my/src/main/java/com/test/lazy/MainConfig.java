package com.test.lazy;

import com.test.importt.component.MyImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.*;

@Configuration
public class MainConfig {
	@Bean
	@Lazy
	public Person person(){
		Person person = new Person();
		person.setName("小白");
		person.setAge(18);
		return person;
	}
}
