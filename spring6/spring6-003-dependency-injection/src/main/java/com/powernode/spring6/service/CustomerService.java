package com.powernode.spring6.service;

import com.powernode.spring6.dao.UserDao;
import com.powernode.spring6.dao.VipDao;

/**
 * Bean
 * @author 动力节点
 * @version 1.0
 * @className CustomerService
 * @since 1.0
 **/
public class CustomerService {

    private UserDao userDao;
    private VipDao vipDao;

    /*public CustomerService(UserDao userDao, VipDao vipDao) {
        this.userDao = userDao;
        this.vipDao = vipDao;
    }*/

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setVipDao(VipDao vipDao) {
        this.vipDao = vipDao;
    }

    public void save(){
        userDao.insert();
        vipDao.insert();
    }

}
