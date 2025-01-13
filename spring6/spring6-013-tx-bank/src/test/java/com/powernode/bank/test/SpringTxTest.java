package com.powernode.bank.test;

import com.powernode.bank.Spring6Config;
import com.powernode.bank.pojo.Account;
import com.powernode.bank.service.AccountService;
import com.powernode.bank.service.impl.IsolationService1;
import com.powernode.bank.service.impl.IsolationService2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author 动力节点
 * @version 1.0
 * @className SpringTxTest
 * @since 1.0
 **/
public class SpringTxTest {

    @Test
    public void testNoXML(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        try {
            accountService.transfer("act-001", "act-002", 10000);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIsolation1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService1 i1 = applicationContext.getBean("i1", IsolationService1.class);
        i1.getByActno("act-004");
    }

    @Test
    public void testIsolation2() throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService2 i2 = applicationContext.getBean("i2", IsolationService2.class);
        Account act = new Account("act-004", 1000.0);
        i2.save(act);
    }

    @Test
    public void testPropagation() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        // 获取1号service对象
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        Account act = new Account("act-003", 1000.0);
        accountService.save(act);
    }

    @Test
    public void testSpringTx() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        try {
            accountService.transfer("act-001", "act-002", 10000);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
