package com.test.lifecycle.component;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class MySmartLifecycle implements SmartLifecycle {
	private boolean running = false;

	public MySmartLifecycle(){
		System.out.println("MySmartLifecycle 构造方法");
	}

	@Override
	public void start() {
		running = true;
		System.out.println("MySmartLifecycle#start()  ---  running = true");
	}

	@Override
	public void stop() {
		running = false;
		System.out.println("MySmartLifecycle#stop()  ---  running = false");
	}

	@Override
	public boolean isRunning() {
		return running;
	}
}
