package com.powernode.spring6.test;

import com.powernode.spring6.biz.UserService;
import com.powernode.spring6.biz.VipService;
import com.powernode.spring6.service.AccountService;
import com.powernode.spring6.service.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 动力节点
 * @version 1.0
 * @className AOPRealAppTest
 * @since 1.0
 **/
public class AOPRealAppTest {

    @Test
    public void testSecurityLog(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        VipService vipService = applicationContext.getBean("vipService", VipService.class);

        userService.saveUser();
        userService.deleteUser();
        userService.modifyUser();
        userService.getUser();

        vipService.saveVip();
        vipService.deleteVip();
        vipService.modifyVip();
        vipService.getVip();
    }

    @Test
    public void testTransaction(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        accountService.transfer();
        accountService.withdraw();
        orderService.generate();
        orderService.cancel();
    }

}
