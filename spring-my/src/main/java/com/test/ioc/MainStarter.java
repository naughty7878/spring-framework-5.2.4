package com.test.ioc;

import com.test.ioc.component.PersonAPostContruct;
import com.test.ioc.person.Person;
import com.test.ioc.person.PersonFactoryBean;
import com.test.ioc.person.PersonIInitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainStarter {

	public static void main(String[] args) {

		// 注解配置引用上下文
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

		// 1、简单获取bean
		Person person1 = (Person) context.getBean("person");
		System.out.println("person:" + person1);
		Person person2 = (Person) context.getBean("person");
		System.out.println("person:" + person2);

		// 2、测试实现FactoryBean接口的PersonIFactoryBean的用法
		// 通过普通beanName 获取的是Person对象，调用FactoryBean接口中的getObject()方法获取对象
		// 多次获取不会重复调用getObject()方法获取对象，会从容器中的缓存中去
//		Person person1 = (Person) context.getBean("personFactoryBean");
//		System.out.println(person1);
//		Person person2 = (Person) context.getBean("personFactoryBean");
//		System.out.println(person2);
//
//		// 通过& + beanName，获取的是PersonEFactoryBean对象
//		PersonFactoryBean personFactoryBean = (PersonFactoryBean) context.getBean("&personFactoryBean");
//		System.out.println(personFactoryBean);


		// 3、InstantiationAwareBeanPostProcessor接口Bean后置处理器，见MyInstantiationAwareBeanPostProcessor类

		// 4、@PostConstruct、PreDestroy的使用
//		PersonAPostContruct person1 = (PersonAPostContruct) context.getBean("personAPostContruct");
//		System.out.println(person1);
//		PersonAPostContruct person2 = (PersonAPostContruct) context.getBean("personAPostContruct");
//		System.out.println(person2);

		// 5、InitializingBean、DisposableBean接口的使用
//		PersonIInitializingBean person1 = (PersonIInitializingBean) context.getBean("personIInitializingBean");
//		System.out.println("personIInitializingBean:" + person1);

		context.close();
	}
}
