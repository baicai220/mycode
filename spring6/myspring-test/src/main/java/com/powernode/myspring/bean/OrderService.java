package com.powernode.myspring.bean;

/**
 * @author 动力节点
 * @version 1.0
 * @className OrderService
 * @since 1.0
 **/
public class OrderService {

    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void generate(){
        orderDao.insert();
    }

}
