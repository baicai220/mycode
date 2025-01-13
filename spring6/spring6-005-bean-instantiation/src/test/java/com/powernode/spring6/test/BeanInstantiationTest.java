package com.powernode.spring6.test;

import com.powernode.spring6.bean.*;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 动力节点
 * @version 1.0
 * @className BeanInstantiationTest
 * @since 1.0
 **/
public class BeanInstantiationTest {

    @Test
    public void testDate(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = applicationContext.getBean("studentBean", Student.class);
        System.out.println(student);
    }


    @Test
    public void testInstantiation4(){
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }


    @Test
    public void testInstantiation3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Gun gun = applicationContext.getBean("gun", Gun.class);
        System.out.println(gun);
    }

    @Test
    public void testInstantiation2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Star star = applicationContext.getBean("star", Star.class);
        System.out.println(star);
    }

    @Test
    public void testInstantiation1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);
    }

}
