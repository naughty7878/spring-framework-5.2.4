package com.test.ioc.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {
	@Override
	public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
		System.out.println("～BeforeDestruction：我感知到 " + beanName + " 销毁前～");
	}

	@Override
	public boolean requiresDestruction(Object bean) {
		System.out.println("～requiresDestruction：我感知到 " + bean + " 需要销毁～");
		return true;
	}
}
