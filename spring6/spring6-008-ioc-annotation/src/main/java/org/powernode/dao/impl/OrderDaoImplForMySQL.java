package org.powernode.dao.impl;

import org.powernode.dao.OrderDao;
import org.springframework.stereotype.Repository;

/**
 * @author 动力节点
 * @version 1.0
 * @className OrderDaoImplForMySQL
 * @since 1.0
 **/
@Repository("orderDaoImplForMySQL")
public class OrderDaoImplForMySQL implements OrderDao {
    @Override
    public void insert() {
        System.out.println("MySQL数据库正在保存订单信息...");
    }
}
