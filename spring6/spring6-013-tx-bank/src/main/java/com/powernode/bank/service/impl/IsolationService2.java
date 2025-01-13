package com.powernode.bank.service.impl;

import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.pojo.Account;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @author 动力节点
 * @version 1.0
 * @className IsolationService2
 * @since 1.0
 **/
@Service("i2")
public class IsolationService2 {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    // 2号
    // 负责insert
    //@Transactional(readOnly = true, timeout = 10) // 设置事务超时时间为10秒。
    //@Transactional(rollbackFor = RuntimeException.class) // 只要发生RuntimeException或者这个异常的子类异常，都回滚。
    @Transactional(noRollbackFor = NullPointerException.class) // 当异常是空指针异常的时候不回滚。
    public void save(Account act) throws IOException {

        // 睡眠一会
        /*try {
            Thread.sleep(1000 * 15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        accountDao.insert(act);

        // 模拟异常
        if(1 == 1){
            //throw new IOException();
            throw new RuntimeException();
            //throw new NullPointerException();
        }

        /*// 睡眠一会
        try {
            Thread.sleep(1000 * 20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        // 可以在这里写一个无关紧要的DML语句
    }

}
