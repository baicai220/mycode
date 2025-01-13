package com.powernode.spring6.service.impl;

import com.powernode.spring6.dao.UserDao;
import com.powernode.spring6.dao.impl.UserDaoImplForMySQL;
import com.powernode.spring6.dao.impl.UserDaoImplForOracle;
import com.powernode.spring6.service.UserService;

/**
 * @author 动力节点
 * @version 1.0
 * @className UserServiceImpl
 * @since 1.0
 **/
public class UserServiceImpl implements UserService {
    //private UserDao userDao = new UserDaoImplForMySQL();

    // 修改为
    //private UserDao userDao = new UserDaoImplForOracle();

    private UserDao userDao;

    @Override
    public void deleteUser() {
        userDao.deleteById();
    }
}
