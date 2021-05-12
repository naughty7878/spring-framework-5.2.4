package com.test.listener.component;

import com.test.listener.MyApplicationEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

	@Component
	public class MyCustomListener {

		@EventListener
		public void processEvent(ApplicationEvent event){
			System.out.println("MyCustomListener: " +  "正在处理器事件");
			System.out.println("MyCustomListener-事件源：" + event.getSource());
			if(event instanceof MyApplicationEvent) {
				System.out.println("MyCustomListener-事件msg：" + ((MyApplicationEvent) event).getMsg());
			}
		}

	}
