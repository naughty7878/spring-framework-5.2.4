package com.test.circulardependence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MainStarter {

	static Map<String, RootBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);


	public static void main(String[] args) throws Exception {
		// 注册Bean定义
		beanDefinitionMap.put("instanceA", new RootBeanDefinition(InstanceA.class));
		beanDefinitionMap.put("instanceB", new RootBeanDefinition(InstanceB.class));

		// 获取Bean
		InstanceA instanceA = (InstanceA) getBean("instanceA");
		instanceA.say();
	}

	static Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256);
	static Map<String, Object> earlySingletonObjects = new ConcurrentHashMap<>(256);

	// 获取Bean
	private static Object getBean(String beanName) throws Exception {

		// 先去缓存中去
		Object singleton = getSingleton(beanName);
		if(singleton != null) {
			return singleton;
		}

		// 1、实例化Bean
		RootBeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
		Class<?> beanClass = beanDefinition.getBeanClass();
		Object instance = beanClass.newInstance();

		earlySingletonObjects.put(beanName, instance);

		// 2、填充属性
		Field[] declaredFields = beanClass.getDeclaredFields();
		for (Field field : declaredFields) {
			Annotation[] annotations = field.getAnnotations();
			Autowired annotation = field.getAnnotation(Autowired.class);
			if (annotation != null) {
				field.setAccessible(true);
				// 如是是Autowired自动注入的
				Object depenOn = getBean(field.getName());
				field.set(instance, depenOn);
			}
		}

		// 3、初始化Bean
		// 略... 调用对象的init()方法

		// 4、添加到缓存
		singletonObjects.put(beanName, instance);

		return instance;
	}

	// 从缓存中获取对象
	public static Object getSingleton(String beanName) {
		Object obj = null;
		// 一级缓存，保存有效对象
		if(singletonObjects.containsKey(beanName)) {
			obj = singletonObjects.get(beanName);
		}
		// 二级缓存，保存半成品对象
		else if (earlySingletonObjects.containsKey(beanName)) {
			obj = earlySingletonObjects.get(beanName);
		}
		return obj;
	}

}
