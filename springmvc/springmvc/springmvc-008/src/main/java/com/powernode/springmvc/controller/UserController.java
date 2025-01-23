package com.powernode.springmvc.controller;

import com.powernode.springmvc.bean.User;
import com.powernode.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName: UserController
 * Description:
 * Datetime: 2024/3/28 20:45
 * Author: 老杜@动力节点
 * Version: 1.0
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getById(@PathVariable("id") Long id){
        User user = userService.getById(id);
        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }else{
            return ResponseEntity.ok(user);
        }
    }

}
