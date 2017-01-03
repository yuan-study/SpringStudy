package com.pingan.myspring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by zhangyuanyuan031 on 2017/1/3.
 */
public class AroundAdvice implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.err.println("这个roundAdvice的方法执行前要做的事情");
        Object obj = methodInvocation.proceed();
        System.err.println("这个roundAdvice的方法执行后要做的事情");
        return obj;
    }
}
