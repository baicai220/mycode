package com.powernode.spring6.dao.impl;

import com.powernode.spring6.dao.UserDao;

/**
 * @author 动力节点
 * @version 1.0
 * @className UserDaoImplForMySQL
 * @since 1.0
 **/
public class UserDaoImplForMySQL implements UserDao {
    @Override
    public void deleteById() {
        System.out.println("MySQL数据库正在删除用户信息......");
    }
}
