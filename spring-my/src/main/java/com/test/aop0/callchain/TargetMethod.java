package com.test.aop0.callchain;

import java.lang.reflect.Method;

public class TargetMethod {
    /**
     *  目标对象（也被称为被代理对象）
     */
    private Object target;

    /**
     * 目标对象中的被代理方法
     */
    private Method method;

    /**
     * 被代理方法的参数列表
     */
    private Object[] args;

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}
}