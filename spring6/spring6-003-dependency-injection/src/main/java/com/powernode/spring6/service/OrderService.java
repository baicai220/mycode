package com.powernode.spring6.service;

import com.powernode.spring6.dao.OrderDao;

/**
 * @author 动力节点
 * @version 1.0
 * @className OrderService
 * @since 1.0
 **/
public class OrderService {

    private OrderDao orderDao;

    // 通过set方法给属性赋值。
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    /**
     * 生成订单的业务方法。。。
     */
    public void generate(){
        orderDao.insert();
    }
}
