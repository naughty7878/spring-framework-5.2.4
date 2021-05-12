package com.test.listener;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.test.listener.component")
public class MainConfig {
	public MainConfig(){
		System.out.println("MainConfig 构造方法");
	}
}
