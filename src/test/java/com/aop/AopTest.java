package com.aop;

import com.pingan.myspring.aop.Person;
import org.aopalliance.aop.Advice;
import org.junit.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by zhyy on 2017/1/2.
 */
public class AopTest {
    @Test
    public void testAop() throws Exception{
        Person person = new Person();
        ProxyFactory proxyFactory=null;
        Pointcut pointcut=null;
        Advice advice=null;
        Advisor advisor=null;

    }
}
