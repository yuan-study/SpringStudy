package com.pingan.myspring.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by zhangyuanyuan031 on 2017/1/3.
 */
public class MyAfterAdvice implements AfterReturningAdvice {
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("这是后置通知做的事情，方法名称是：" + method.getName());
    }
}
