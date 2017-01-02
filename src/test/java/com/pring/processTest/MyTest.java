package com.pring.processTest;

import com.pingan.myspring.dto.Car;
import com.pingan.myspring.dto.Cat;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhyy on 2017/1/2.
 */
public class MyTest {
    @Test
    public void testProcess() throws Exception{
        ApplicationContext applictionContent = new ClassPathXmlApplicationContext("META-INF/spring/01.xml");
        Car car=applictionContent.getBean("car",Car.class);
        System.out.println("*******************************");
        car.setName("baoma");
        System.out.println(car.getName());
        Cat cat = applictionContent.getBean("cat",Cat.class);
        cat.climb();


    }
}
