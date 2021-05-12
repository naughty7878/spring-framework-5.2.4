package com.test.ioc.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

@Component
public class MySmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

	// 预言Bean的类型
	@Override
	public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("～predictBeanType：我感知到 " + beanName + " 预言类型～");
		return null;
	}

	// 获取早期对象引用，默认返回原bean
	@Override
	public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
		System.out.println("～getEarlyBeanReference：我感知到 " + beanName + " 早期引用～");
		return bean;
	}

	// 确认候选构造器
	@Override
	public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("～determineCandidateConstructors：我感知到 " + beanName + " 确认候选构造器～");
		return null;
	}
}
