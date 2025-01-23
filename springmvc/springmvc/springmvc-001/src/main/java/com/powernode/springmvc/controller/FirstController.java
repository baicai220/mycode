package com.powernode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: FirstController
 * Description:
 * Datetime: 2024/3/25 20:15
 * Author: 老杜@动力节点
 * Version: 1.0
 */
@Controller
public class FirstController {

    @RequestMapping("/")
    public String toIndex(){
        // 返回逻辑视图名称
        return "index";
    }

    // 请求映射
    // 这个方法是一个实例方法
    // 这个方法目前返回一个String字符串
    // 返回值代表的是一个逻辑视图名称
    //@RequestMapping(value="/test")
    @RequestMapping("/test")
    public String hehe(){
        // 返回一个逻辑视图名称
        return "first";
    }

    @RequestMapping("/heihei")
    public String haha(){
        // 处理核心业务
        // 返回一个逻辑视图名称
        return "other";
    }

}
