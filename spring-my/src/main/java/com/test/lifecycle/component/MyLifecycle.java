package com.test.lifecycle.component;

import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

@Component
public class MyLifecycle implements Lifecycle {

	private boolean running = false;

	public MyLifecycle(){
		System.out.println("MyLifecycle 构造方法");
	}

	@Override
	public void start() {
		running = true;
		System.out.println("MyLifecycle#start()  ---  running = true");
	}

	@Override
	public void stop() {
		running = false;
		System.out.println("MyLifecycle#stop()  ---  running = false");
	}

	@Override
	public boolean isRunning() {
		return running;
	}


}
