package com.powernode.spring6.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 动力节点
 * @version 1.0
 * @className OrderDao
 * @since 1.0
 **/
public class OrderDao {

    private static final Logger logger = LoggerFactory.getLogger(OrderDao.class);

    public void insert(){
        logger.info("订单正在生成....");
    }
}
