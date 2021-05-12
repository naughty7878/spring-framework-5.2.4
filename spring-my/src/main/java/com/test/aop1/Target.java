package com.test.aop1;

import org.springframework.beans.factory.annotation.Autowired;

//public class Target {
public class Target implements TargetInterface {

	@Override
	public void targetMethod() {
		System.out.println("---Target#targetMethod()---");
	}

	@Override
	public void targetMethod2() {
		System.out.println("---Target#targetMethod2()---");
	}
}
