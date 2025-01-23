package com.powernode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: IndexController
 * Description:
 * Datetime: 2024/3/27 15:29
 * Author: 老杜@动力节点
 * Version: 1.0
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }
}
