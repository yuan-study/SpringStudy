package com.pingan.myspring.aop;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by zhangyuanyuan031 on 2017/1/3.
 */
public class MyBeanPostProcessListenerPersonCreate implements BeanPostProcessor, ApplicationContextAware {
    private ApplicationContext act;

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Person){
            ProxyFactory proxyFactory = new ProxyFactory(bean);
            RegexpMethodPointcutAdvisor advisor = (RegexpMethodPointcutAdvisor) act.getBean("advisor",RegexpMethodPointcutAdvisor.class);
            proxyFactory.addAdvisors(advisor);
            return proxyFactory.getProxy();
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }


    public void setApplicationContext(ApplicationContext act) throws BeansException {
        this.act = act;
    }
}
