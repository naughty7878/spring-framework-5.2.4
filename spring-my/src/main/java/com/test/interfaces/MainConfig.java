package com.test.interfaces;

import com.test.interfaces.component.ClassA;
import com.test.interfaces.component.DefaultInterface;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@ComponentScan("com.test.propertysource.component")
@Import(ClassA.class)
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
