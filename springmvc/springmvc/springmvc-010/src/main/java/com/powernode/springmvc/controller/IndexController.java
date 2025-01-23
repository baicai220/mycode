package com.powernode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName: IndexController
 * Description:
 * Datetime: 2024/3/29 12:09
 * Author: 老杜@动力节点
 * Version: 1.0
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String toIndex() {
        return "index";
    }
}
