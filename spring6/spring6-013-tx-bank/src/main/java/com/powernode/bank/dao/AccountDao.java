package com.powernode.bank.dao;

import com.powernode.bank.pojo.Account;

/**
 * 专门负责账户信息的CRUD操作。
 * DAO中只执行SQL语句，没有任何业务逻辑。
 * 也就是说DAO不和业务挂钩。
 * @author 动力节点
 * @version 1.0
 * @className AccountDao
 * @since 1.0
 **/
public interface AccountDao {

    /**
     * 根据账号查询账户信息
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 更新账户信息。
     * @param act
     * @return
     */
    int update(Account act);

    /**
     * 保存账户信息
     * @param act
     * @return
     */
    int insert(Account act);

}
