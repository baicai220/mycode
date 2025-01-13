package com.powernode.spring6.test;

import com.powernode.spring6.bean.*;
import com.powernode.spring6.jdbc.MyDataSource;
import com.powernode.spring6.jdbc.MyDataSource1;
import com.powernode.spring6.jdbc.MyDataSource2;
import com.powernode.spring6.service.CustomerService;
import com.powernode.spring6.service.OrderService;
import com.powernode.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author 动力节点
 * @version 1.0
 * @className SpringDITest
 * @since 1.0
 **/
public class SpringDITest {

    public static void main(String[] args) {
        System.out.println(new Date());
    }

    @Test
    public void testProperties(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-properties.xml");
        MyDataSource ds = applicationContext.getBean("ds", MyDataSource.class);
        System.out.println(ds);
    }

    @Test
    public void testAutowire(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");

        //OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        //orderService.generate();

        CustomerService cs = applicationContext.getBean("cs", CustomerService.class);
        cs.save();
    }

    @Test
    public void testUtil(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-util.xml");
        MyDataSource1 ds1 = applicationContext.getBean("ds1", MyDataSource1.class);
        MyDataSource2 ds2 = applicationContext.getBean("ds2", MyDataSource2.class);
        System.out.println(ds1);
        System.out.println(ds2);
    }

    @Test
    public  void  testC(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-c.xml");
        People peopleBean = applicationContext.getBean("peopleBean", People.class);
        System.out.println(peopleBean);
    }
    @Test
    public void testP(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        Dog dogBean = applicationContext.getBean("dogBean", Dog.class);
        System.out.println(dogBean);
    }

    @Test
    public void testSpecial(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        MathBean mathBean = applicationContext.getBean("mathBean", MathBean.class);
        System.out.println(mathBean);
    }

    @Test
    public void testNull(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        Cat catBean = applicationContext.getBean("catBean", Cat.class);
        System.out.println(catBean.getName().toUpperCase());
    }

    @Test
    public void testCollection(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-collection.xml");
        Person personBean = applicationContext.getBean("personBean", Person.class);
        System.out.println(personBean);
    }

    @Test
    public void testArray(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array.xml");
        QianDaYe yuQian = applicationContext.getBean("yuQian", QianDaYe.class);
        System.out.println(yuQian);
    }

    @Test
    public void testCascade(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cascade.xml");

        Student studentBean = applicationContext.getBean("studentBean", Student.class);
        System.out.println(studentBean);

        Clazz clazzBean = applicationContext.getBean("clazzBean", Clazz.class);
        System.out.println(clazzBean);
    }

    @Test
    public void testMyDataSource(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);
    }

    @Test
    public void testSimpleTypeSet(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        //User user = applicationContext.getBean("userBean", User.class);
        //System.out.println(user);

        SimpleValueType svt = applicationContext.getBean("svt", SimpleValueType.class);
        System.out.println(svt);
    }

    @Test
    public void testSetDI2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        OrderService orderService = applicationContext.getBean("orderServiceBean", OrderService.class);
        orderService.generate();

        OrderService orderService2 = applicationContext.getBean("orderServiceBean2", OrderService.class);
        orderService2.generate();
    }

    @Test
    public void testConstructorDI(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService customerService = applicationContext.getBean("csBean", CustomerService.class);
        customerService.save();

        CustomerService csBean2 = applicationContext.getBean("csBean2", CustomerService.class);
        csBean2.save();

        CustomerService csBean3 = applicationContext.getBean("csBean3", CustomerService.class);
        csBean3.save();
    }

    @Test
    public void testSetDI(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userServiceBean", UserService.class);
        userService.saveUser();
    }
}
