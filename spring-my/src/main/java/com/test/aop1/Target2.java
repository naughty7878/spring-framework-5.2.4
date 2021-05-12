package com.test.aop1;

import org.springframework.beans.factory.annotation.Autowired;

//public class Target {
public class Target2 implements TargetInterface {

	@Autowired
	private TargetInterface self;  // 这个装配的对象是代理对象

	@Override
	public void targetMethod() {
		System.out.println("---Target#targetMethod()---");
		self.targetMethod2();
	}

	@Override
	public void targetMethod2() {
		System.out.println("---Target#targetMethod2()---");
	}
}
