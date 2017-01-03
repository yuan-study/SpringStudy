package com.aop;

import com.pingan.myspring.aop.Person;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.omg.PortableServer.POA;
import org.springframework.aop.Advisor;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor;
import org.springframework.aop.support.DefaultIntroductionAdvisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

/**
 * Created by zhyy on 2017/1/2.
 */
public class AopTest {

    @Test
    public void testSpringXML02() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("META-INF/spring/04.xml");
        Person p = ac.getBean("person", Person.class);
        p.run();
        p.say();
        p.eat();
    }

    @Test
    public void testSpringXML() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("META-INF/spring/03.xml");
        Person p = ac.getBean("personPoxy", Person.class);
        p.run();
        p.say();
        p.eat();
    }

    @Test
    public void testOtherInterceputer() throws Exception {
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.setTarget(new Person());

//        定义切点
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPatterns(".*run.*", ".*say.*", ".*eat.*");
        Advice methodBeforeAdivce = new MethodBeforeAdvice() {
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("前通知");
            }
        };
        Advice methodAfter = new AfterReturningAdvice() {
            public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
                System.out.println("后通知");
            }
        };

        Advice interceputer = new MethodInterceptor() {
            public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                System.out.println("interceputer before advice");
                Object obj = methodInvocation.proceed();
                System.out.println("interceptuter after advice");

                return obj;
            }
        };


        DefaultPointcutAdvisor beforeAdvisor = new DefaultPointcutAdvisor(pointcut, methodBeforeAdivce);
        DefaultPointcutAdvisor afterAdvisor = new DefaultPointcutAdvisor(pointcut, methodAfter);
        DefaultPointcutAdvisor interruptAdvisor = new DefaultPointcutAdvisor(pointcut, interceputer);

        proxyFactoryBean.addAdvisors(beforeAdvisor, afterAdvisor, interruptAdvisor);


        Person p = (Person) proxyFactoryBean.getObject();
//        p.run();
//        p.sayGood("nihao");

        p.eat();
    }

    @Test
    public void testAop() throws Exception {
        Person person = new Person();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(person);
//声明切点
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPatterns(".*run.*", ".*say.*");
        Advice advice = new MethodInterceptor() {
            public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                System.out.println("拦截前做的事情");
                Object object = methodInvocation.proceed();
                System.out.println("拦截后要做的事情");
                return object;
            }
        };
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setAdvice(advice);
        advisor.setPointcut(pointcut);
        proxyFactory.addAdvice(advice);

        Person p = (Person) proxyFactory.getProxy();

        p.run();

        p.say();

        p.sayGood("你好");
    }
}
