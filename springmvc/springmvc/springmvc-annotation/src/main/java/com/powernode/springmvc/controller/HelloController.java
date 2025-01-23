package com.powernode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName: HelloController
 * Description:
 * Datetime: 2024/3/29 19:20
 * Author: 老杜@动力节点
 * Version: 1.0
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello(){
        System.out.println("HelloController#hello()");
        return "hello";
    }

}
