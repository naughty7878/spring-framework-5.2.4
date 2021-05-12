package com.test.aop1;

import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy//(exposeProxy = true)//(proxyTargetClass = true)
@Import(CustomAspect.class)
public class MainConfig {

	@Bean
	public Target target(){
		Target target = new Target();
		return target;
	}

//	@Bean
//	public Target2 target(){
//		Target2 target = new Target2();
//		return target;
//	}


//	@Bean
//	public TargetInterface target(){
//		TargetInterface target = new Target3();
//		return target;
//	}
}
