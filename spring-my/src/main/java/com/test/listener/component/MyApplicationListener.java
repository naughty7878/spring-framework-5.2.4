package com.test.listener.component;

import com.test.listener.MyApplicationEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("MyApplicationListener: " +  "正在处理器事件");
		System.out.println("MyApplicationListener-事件源：" + event.getSource());
		if(event instanceof MyApplicationEvent) {
			System.out.println("MyApplicationListener-事件msg：" + ((MyApplicationEvent) event).getMsg());
		}
	}
}
