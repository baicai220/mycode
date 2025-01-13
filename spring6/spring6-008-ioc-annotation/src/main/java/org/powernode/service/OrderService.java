package org.powernode.service;

import com.powernode.spring6.bean.Order;
import org.powernode.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author 动力节点
 * @version 1.0
 * @className OrderService
 * @since 1.0
 **/
@Service("orderService")
public class OrderService {

    // @Autowired注解使用的时候，不需要指定任何属性，直接使用这个注解即可。
    // 这个注解的作用是根据类型byType进行自动装配。
    //@Autowired
    //private OrderDao orderDao;

    // 如果想解决以上问题，只能根据名字进行装配。
    // @Autowired和@Qualifier联合使用，可以根据名字进行装配。
    //@Autowired
    //@Qualifier("orderDaoImplForOracle")
    //@Qualifier("orderDaoImplForMySQL")
    private OrderDao orderDao;

    /*@Autowired
    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }*/

    /*public OrderService(@Autowired OrderDao orderDao) {
        this.orderDao = orderDao;
    }*/

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    // 如果一个类当中构造方法只有一个，并且构造方法上的参数和属性能够对应上。@Autowired注解可以省略。
    /*public OrderService() {
    }*/

    /*@Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }*/

    public void generate(){
        orderDao.insert();
    }
}
