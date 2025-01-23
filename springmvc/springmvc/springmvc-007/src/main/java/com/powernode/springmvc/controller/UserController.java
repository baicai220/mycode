package com.powernode.springmvc.controller;

import com.powernode.springmvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName: UserController
 * Description:
 * Datetime: 2024/3/27 22:57
 * Author: 老杜@动力节点
 * Version: 1.0
 */
@Controller
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAll(){
        System.out.println("正在查询所有用户信息....");
        return "ok";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getById(@PathVariable("id") String id){
        System.out.println("正在根据用户id查询用户信息...，用户id是" + id);
        return "ok";
    }


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String save(User user) {
        System.out.println("正在保存用户信息...");
        System.out.println(user);
        return "ok";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String modify(User user){
        System.out.println("正在修改用户信息：" + user);
        return "ok";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String del(@PathVariable("id") String id){
        System.out.println("正在删除用户：" + id);
        return "ok";
    }
}























