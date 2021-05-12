package com.test.ioc.component;

import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {
	@Override
	public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
		System.out.println("～postProcessMergedBeanDefinition： " + beanName + " 合成了Bean定义～");
	}

	@Override
	public void resetBeanDefinition(String beanName) {
		System.out.println("～resetBeanDefinition： " + beanName + " 重置了Bean定义～");
	}
}
