package com.test.ioc.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	// 后置处理Bean工厂
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("这里是MyBeanDefinitionRegistryPostProcessor#postProcessBeanFactory()，后置处理Bean工厂逻辑");
	}

	// 后置处理Bean定义注册
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("这里是MyBeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry()，后置处理Bean定义注册逻辑");
	}
}
