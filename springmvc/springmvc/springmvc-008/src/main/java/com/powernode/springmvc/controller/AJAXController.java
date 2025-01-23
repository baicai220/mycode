package com.powernode.springmvc.controller;

import com.powernode.springmvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: AJAXController
 * Description:
 * Datetime: 2024/3/28 15:42
 * Author: 老杜@动力节点
 * Version: 1.0
 */
//@Controller
@RestController
public class AJAXController {

    //@RequestMapping(value = "/ajax", method = RequestMethod.GET)
    /*@GetMapping("/ajax")
    public String ajax(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("hello ajax, my name is Spring MVC!");
        return null;
    }*/

    /*@GetMapping("/ajax")
    public void ajax(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("hello ajax, my name is Spring MVC2!");
    }*/

    /*@GetMapping("/ajax")
    @ResponseBody
    public String ajax() {
        //return "hello ajax, my name is Spring MVC!";
        return "{\"id\":\"1111112222\", \"username\":\"zhangsan\", \"password\":\"1234\"}";
    }*/

    @GetMapping("/ajax")
    //@ResponseBody
    public User ajax() {
        User user = new User(111222L, "lisi", "123");
        return user;
    }

}
