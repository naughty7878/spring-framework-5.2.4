package com.test.propertysource;

import com.test.importt.Person;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.test.propertysource.component")
//@Import(Person.class)
public class MainConfig {

//	// 成员Class
//	@Component
//	class Test1{
//
//	}
//
//	@Component
//	class Test2{
//
//	}
}
