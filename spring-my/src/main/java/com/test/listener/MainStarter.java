package com.test.listener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainStarter {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		// 1、创建一个事件
		MyApplicationEvent myApplicationEvent = new MyApplicationEvent(new Object(), "这是一个的新事件");
		// 2、发布事件
		context.publishEvent(myApplicationEvent);
		// 3、监听器处理
		// .....
		context.close();
	}

}
