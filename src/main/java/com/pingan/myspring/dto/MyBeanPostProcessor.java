package com.pingan.myspring.dto;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhyy on 2017/1/2.
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(bean);
        final Object o =bean;
        Callback callback = new MethodInterceptor() {
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("做拦截前可以在这写:方法名称是"+ "----------"+method.getName());
                for(int i=0;i<args.length;i++){
                    System.out.println(args[i]);
                }
                Object objval=method.invoke(o,args);
//                Object objval = methodProxy.invokeSuper(obj,args);
                System.out.println("做拦截后可以在这写:方法名称是"+ "***********"+method.getName());
                return objval;
            }
        };
        Object proxyObject = Enhancer.create(bean.getClass(), callback);
        return proxyObject;
    }
}
