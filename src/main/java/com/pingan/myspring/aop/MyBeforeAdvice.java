package com.pingan.myspring.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by zhangyuanyuan031 on 2017/1/3.
 */
public class MyBeforeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("这个前置通知要做的事情:可以得到方法名称是：" + method.getName());
    }
}
