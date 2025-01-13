package com.powernode.bank.test;

import com.powernode.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 动力节点
 * @version 1.0
 * @className BankTxTest
 * @since 1.0
 **/
public class BankTxTest {

    @Test
    public void testNoAnnotation(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        try {
            accountService.transfer("act-001", "act-002", 10000.0);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
