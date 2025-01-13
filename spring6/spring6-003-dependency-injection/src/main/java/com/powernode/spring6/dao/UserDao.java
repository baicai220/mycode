package com.powernode.spring6.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean
 * @author 动力节点
 * @version 1.0
 * @className UserDao
 * @since 1.0
 **/
public class UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    public void insert(){
        //System.out.println("数据库正在保存用户信息。");
        // 使用一下log4j2日志框架
        logger.info("数据库正在保存用户信息。");
    }
}
