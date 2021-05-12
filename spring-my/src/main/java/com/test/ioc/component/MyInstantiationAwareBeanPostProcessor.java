package com.test.ioc.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 *	实现InstantiationAwareBeanPostProcessor接口的Bean后置处理器
 *	名称：实例化感知Bean后置处理器
 *	作用：在实例对象实例化后，实现此接口的对象能感知到，并调用相应的方法
 *	条件：需要将其注入到容器中
 */
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

	/**
	 * 感知Bean实例化前，会调用此方法处理
	 * 并返回一个Bean对象，返回的是一个代理类，返回空（默认），表示交给容器去创建
	 * @param beanClass the class of the bean to be instantiated
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("～BeforeInstantiation：我感知到 " + beanName + " 准备实例化了～");
//		if(beanName.equals("person")) {
//			return new Person();
//		}
		return null;
	}

	/**
	 * 感知Bean实例化后，在填充属性前，会调用此方法处理
	 * 并返回一个boolean值，true：继续填充bean的属性，false：不继续填充属性（默认）
	 * @param bean the bean instance created, with properties not having been set yet
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		System.out.println("～AfterInstantiation：我感知到 " + beanName + " 已经实例化了，且准备填充属性了～");
		return true;
	}

	/**
	 * 感知Bean初始化前，会调用此方法处理
	 * 并返回一个处理过的Bean对象，返回空（默认），容器继续使用原始bean进行处理
	 * @param bean the new bean instance
	 * @param beanName the name of the bean
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("～BeforeInitialization：我感知到 " + beanName + " 准备初始化了～");
		return bean;
	}

	/**
	 * 感知Bean初始化后，会调用此方法处理
	 * 并返回一个处理过的Bean对象，返回空（默认），容器继续使用原始bean进行处理
	 * @param bean the new bean instance 容器实例化的Bean对象
	 * @param beanName the name of the bean Bean名称
	 * @return
	 * @throws BeansException
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("～AfterInitialization：我感知到 " + beanName + " 已经初始化了～");
		return bean;
	}


}
