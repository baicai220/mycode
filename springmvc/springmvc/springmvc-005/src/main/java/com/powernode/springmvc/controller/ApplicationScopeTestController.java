package com.powernode.springmvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: ApplicationScopeTestController
 * Description:
 * Datetime: 2024/3/27 11:45
 * Author: 老杜@动力节点
 * Version: 1.0
 */
@Controller
public class ApplicationScopeTestController {

    @RequestMapping("/testApplicationScope")
    public String testApplicationScope(HttpServletRequest request){
        // 将数据存储到application域当中
        // 获取application对象，其实就是获取ServletContext对象
        // 怎么获取ServletContext对象？通过request，通过session都可以获取。
        ServletContext application = request.getServletContext();
        application.setAttribute("testApplicationScope", "在SpringMVC中使用ServletAPI实现application域共享");
        return "ok";
    }
}
