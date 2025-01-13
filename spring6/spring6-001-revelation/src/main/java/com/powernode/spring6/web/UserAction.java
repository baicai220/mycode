package com.powernode.spring6.web;

import com.powernode.spring6.service.UserService;
import com.powernode.spring6.service.impl.UserServiceImpl;

/**
 * 表示层
 * @author 动力节点
 * @version 1.0
 * @className UserAction
 * @since 1.0
 **/
public class UserAction {
    //private UserService userService = new UserServiceImpl();

    // 修改为
    private UserService userService;

    /**
     * 删除用户信息的请求
     */
    public void deleteRequest(){
        userService.deleteUser();
    }
}
