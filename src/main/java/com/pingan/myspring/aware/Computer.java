package com.pingan.myspring.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by zhyy on 2017/1/2.
 */
public class Computer implements ApplicationContextAware,BeanNameAware {
    private String name;
    private ApplicationContext applicationContext;
    public void setBeanName(String name) {
        this.name = name;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

//    想要知道 bean对象的上下文对象，有可能有用，和bean在容器中name名称
    public void getBeanNameAndApplicationContext(){
        System.out.println(this.name);
        System.out.println(this.applicationContext);
    }


}
