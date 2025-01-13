package com.powernode.spring6.service;

import com.powernode.spring6.dao.UserDao;
import com.powernode.spring6.dao.VipDao;

/**
 * Bean
 * @author 动力节点
 * @version 1.0
 * @className UserService
 * @since 1.0
 **/
public class UserService {

    private UserDao userDao;
    private VipDao vipDao;

    public void setAbc(VipDao vipDao){
        this.vipDao = vipDao;
    }

    // set注入的话，必须提供一个set方法。
    // Spring容器会调用这个set方法，来给userDao属性赋值。
    // 我自己写一个set方法，不使用IDEA工具生成的。不符合javabean规范。
    // 至少这个方法是以set单词开始的。前三个字母不能随便写，必须是“set"
    /*public void setMySQLUserDao(UserDao xyz){
        this.userDao = xyz;
    }*/


    // 这个set方法是IDEA工具生成的，符合javabean规范。
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(){
        // 保存用户信息到数据库
        userDao.insert();
        vipDao.insert();
    }
}
