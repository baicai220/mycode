package com.powernode.bank.service;

import com.powernode.bank.pojo.Account;

import java.util.List;

/**
 * @author 动力节点
 * @version 1.0
 * @className AccountService
 * @since 1.0
 **/
public interface AccountService {

    /**
     * 开户
     * @param act
     * @return
     */
    int save(Account act);

    /**
     * 销毁
     * @param actno
     * @return
     */
    int deleteByActno(String actno);

    /**
     * 修改账户
     * @param account
     * @return
     */
    int modify(Account account);

    /**
     * 查询账户
     * @param actno
     * @return
     */
    Account getByActno(String actno);

    /**
     * 获取所有账户
     * @return
     */
    List<Account> getAll();

    /**
     * 转账
     * @param fromActno
     * @param toActno
     * @param moeny
     */
    void transfer(String fromActno, String toActno, double moeny);

}
