package com.test.aop.chaindemo;

import com.test.aop.doc.TulingCalculate;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.List;

public class MyMethodInvocation implements MethodInvocation {

	protected List<MethodInterceptor> interceptors;

	protected final List<Object> target;

	public MyMethodInvocation(List<Object> target) {
		this.target = target;
	}

	public void addMethodInterceptor(MethodInterceptor methodInterceptor){
		interceptors.add(methodInterceptor);
	}

	// 获取参数
	@Override
	public Object[] getArguments() {
		return new Object[0];
	}

	// 处理
	@Override
	public Object proceed() throws Throwable {
		int i =  0;
		interceptors.get(i).invoke(this);
		return null;
	}

	// 获取this
	@Override
	public Object getThis() {
		return target;
	}

	// 获取静态部分
	@Override
	public AccessibleObject getStaticPart() {
		return null;
	}

	@Override
	public Method getMethod() {
		try {
			return target.getClass().getMethod("size");
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
}
