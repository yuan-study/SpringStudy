package com.pingan.myspring.aspectJ;

import com.pingan.myspring.aop.Person;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;

/**
 * Created by zhangyuanyuan031 on 2017/1/3.
 */
public class How2UseAspectJ {
    public static void main(String[] args){
        Person p = new Person();
        /*弄个代理类*/
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(p);

        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression("execution(* com.pingan.myspring.aop..*(..))");
        Advice advice = new MethodInterceptor() {
            public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                System.err.println("通知前要做的事情");
                Object obj = methodInvocation.proceed();
                System.err.println("通知后要做的事情");
                return obj;
            }
        };
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(aspectJExpressionPointcut,advice);
        proxyFactoryBean.addAdvisors(advisor);
        Person person= (Person) proxyFactoryBean.getObject();
        person.run();
        person.say();
    }
}
