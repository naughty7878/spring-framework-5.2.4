package com.test.aop0.callchain;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class JdkDynamicProxy1 implements InvocationHandler {
    /**
     *  目标对象（也被称为被代理对象）
     *
     *      Java 代理模式的一个必要要素就是代理对象要能拿到被代理对象的引用
     */
    private Object target;

    /**
     * 用来标识 InvocationHandler invoke 调用
     */
    private String tag;

    public JdkDynamicProxy1(Object target){
        this.target=target;
    }

    /**
     * 回调方法
     * @param proxy JDK 生成的代理对象
     * @param method 被代理的方法（也就是需要增强的方法）
     * @param args  被代理方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 直接输出 hashCode 值，避免 invoke 递归调用，导致栈溢出
        if (method.getName().equals("hashCode")) {
            return hashCode();
        }

        System.out.println("JdkDynamicProxy1 invoke 方法执行前---------------" + info(proxy));
        Object object= method.invoke(this.target, args);
        System.out.println("JdkDynamicProxy1 invoke 方法执行后----------------" + info(proxy));
        return object;
    }

    /**
     * 输出代理类的一些信息，比如类名，hashCode 等
     * @param proxy
     * @return
     */
    private String info(Object proxy) {
        return proxy.getClass().getName() + ":" + proxy.hashCode() + "----------------" + this.tag;
    }

    /**
     * 获取被代理接口实例对象
     *
     *      通过 Proxy.newProxyInstance 可以获得一个代理对象，它实现了 target.getClass().getInterfaces() 接口
     *
     * @param <T>
     * @return
     */
    public <T> Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}