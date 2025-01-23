package com.powernode.springmvc.service;

import com.powernode.springmvc.bean.User;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserService
 * Description:
 * Datetime: 2024/3/28 20:47
 * Author: 老杜@动力节点
 * Version: 1.0
 */
@Service
public class UserService {

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    public User getById(Long id) {
        if(id == 1){
            return new User(111L, "zhangsan", "13234");
        }
        return null;
    }
}
