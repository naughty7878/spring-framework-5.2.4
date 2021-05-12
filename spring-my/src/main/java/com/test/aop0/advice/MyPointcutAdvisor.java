package com.test.aop0.advice;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

public class MyPointcutAdvisor implements PointcutAdvisor {

    private Pointcut pointcut = new MyPointcut();

    private Advice advice;

    public MyPointcutAdvisor(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        return this.pointcut;
    }

    @Override
    public Advice getAdvice() {
        return this.advice;
    }

    /**
     * 此方法暂时忽略，不需要理会
     */
    @Override
    public boolean isPerInstance() {
        return false;
    }
}