package com.test.aop2;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
//@EnableAspectJAutoProxy
public class MainConfig {

//	@Bean
	public Target target(){
		Target target = new Target();
		return target;
	}

	@Bean
	public MyMethodInterceptor myMethodInterceptor(){
		MyMethodInterceptor myMethodInterceptor = new MyMethodInterceptor();
		return myMethodInterceptor;
	}

	@Bean
	public ProxyFactoryBean proxyFactoryBean(){
		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
		proxyFactoryBean.setInterceptorNames("myMethodInterceptor");
		proxyFactoryBean.setTarget(target());
		return proxyFactoryBean;
	}

}
