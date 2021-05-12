package com.test.aop0.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceptor implements MethodInterceptor {

        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            System.out.println("MyMethodInterceptor invoke 调用 before invocation.proceed");

            Object ret = invocation.proceed();

            System.out.println("MyMethodInterceptor invoke 调用 after invocation.proceed");
            return ret;
        }
    }