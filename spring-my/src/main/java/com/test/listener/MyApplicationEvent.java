package com.test.listener;

import org.springframework.context.ApplicationEvent;

public class MyApplicationEvent extends ApplicationEvent {

	private String msg;

	public MyApplicationEvent(Object source) {
		super(source);
	}

	public MyApplicationEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
