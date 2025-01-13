package com.powernode.spring6.service;

import org.springframework.stereotype.Service;

/**
 * @author 动力节点
 * @version 1.0
 * @className AccountService
 * @since 1.0
 **/
@Service
public class AccountService { // 目标对象

    // 目标方法
    // 转账的业务方法
    public void transfer(){
        System.out.println("银行账户正在完成转账操作...");
    }

    // 目标方法
    // 取款的业务方法
    public void withdraw(){
        System.out.println("正在取款，请稍后...");
    }

}
