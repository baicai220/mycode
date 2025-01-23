package com.powernode.oa.controller;

import org.springmvc.stereotype.Controller;
import org.springmvc.ui.ModelMap;
import org.springmvc.web.bind.annotation.RequestMapping;
import org.springmvc.web.bind.annotation.RequestMethod;

/**
 * ClassName: UserController
 * Description:
 * Datetime: 2024/4/3 10:55
 * Author: 老杜@动力节点
 * Version: 1.0
 */
@Controller
public class UserController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        // 向request域中绑定数据
        modelMap.addAttribute("username", "lisi");
        // 转发
        return "index";
    }
}
