package com.test.lifecycle;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.test.lifecycle.component")
public class MainConfig {
	public MainConfig(){
		System.out.println("MainConfig 构造方法");
	}
}
