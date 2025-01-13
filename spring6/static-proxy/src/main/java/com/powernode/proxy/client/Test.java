package com.powernode.proxy.client;

import com.powernode.proxy.service.OrderService;
import com.powernode.proxy.service.OrderServiceImpl;
import com.powernode.proxy.service.OrderServiceImplSub;
import com.powernode.proxy.service.OrderServiceProxy;

/**
 * @author 动力节点
 * @version 1.0
 * @className Test
 * @since 1.0
 **/
public class Test {
    public static void main(String[] args) {
        /*OrderService orderService = new OrderServiceImpl();
        orderService.generate();
        orderService.detail();
        orderService.modify();*/

        /*OrderService orderService = new OrderServiceImplSub();
        orderService.generate();
        orderService.detail();
        orderService.modify();*/

        // 创建目标对象
        OrderService target = new OrderServiceImpl();
        // 创建代理对象
        OrderService proxy = new OrderServiceProxy(target);
        // 调用代理对象的代理方法
        proxy.generate();
        proxy.modify();
        proxy.detail();
    }
}
