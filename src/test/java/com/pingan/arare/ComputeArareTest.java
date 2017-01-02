package com.pingan.arare;

import com.pingan.myspring.aware.Computer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhyy on 2017/1/2.
 */
public class ComputeArareTest {
    @Test
    public void testClassAware() throws Exception{
        ApplicationContext ac = new ClassPathXmlApplicationContext("META-INF/spring/02.xml");
        System.out.println("*******************************************");
        System.out.println(ac);
        Computer computer =ac.getBean("computer", Computer.class);
        computer.getBeanNameAndApplicationContext();
    }
}
