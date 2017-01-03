package com.aspectj;

import com.pingan.myspring.aop.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangyuanyuan031 on 2017/1/3.
 */
public class AjspectTest {
    @Test
    public void testAspectJ() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("META-INF/spring/05.xml");
        Person person = ac.getBean("person", Person.class);
        person.run();
        person.say();
    }
}
