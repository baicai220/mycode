package com.powernode.ssm.service;

import com.powernode.ssm.bean.User;

/**
 * ClassName: UserService
 * Description:
 * Datetime: 2024/4/1 17:04
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public interface UserService {

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    User getById(Long id);

}
