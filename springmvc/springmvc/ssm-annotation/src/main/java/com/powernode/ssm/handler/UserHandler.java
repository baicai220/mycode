package com.powernode.ssm.handler;

import com.powernode.ssm.bean.User;
import com.powernode.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: UserHandler
 * Description:
 * Datetime: 2024/4/1 17:05
 * Author: 老杜@动力节点
 * Version: 1.0
 */
@RestController
@RequestMapping("/users")
public class UserHandler {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User detail(@PathVariable("id") Long id){
        User user = userService.getById(id);
        return user;
    }

}
