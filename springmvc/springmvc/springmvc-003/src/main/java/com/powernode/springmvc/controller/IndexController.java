package com.powernode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName: IndexController
 * Description:
 * Datetime: 2024/3/25 23:08
 * Author: 老杜@动力节点
 * Version: 1.0
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    // 对于注解来说：如果是一个数组，数组中只有一个元素，大括号是可以省略的
    //@RequestMapping(value = "/testVal1")
    // 对于注解来说，如果只使用了一个value属性，那么value也是可以省略的。
    @RequestMapping("/testVal2")
    //@RequestMapping(value = {"/testVal1", "/testVal2"})
    //@RequestMapping(path = {"/testVal1", "/testVal2"})
    public String testRequestMappingValue(){
        // 处理业务逻辑
        // 返回逻辑视图
        return "test_value";
    }

    //@RequestMapping(value = "/x?z/testAntValue")
    //@RequestMapping(value = "/x*z/testAntValue")
    //@RequestMapping(value = "/x**z/testAntValue")
    //@RequestMapping(value = "/**/testAntValue") // 报错了，Spring6报错。Spring5不会报错。
    @RequestMapping(value = "/testAntValue/**")
    public String testRequestMappingAntValue(){
        return "ok";
    }

    // 这里就映射了一个RESTFul风格的URL。
    @RequestMapping(value = "/login/{a}/{b}")
    public String testRESTFulURL(
            @PathVariable("a")
            String username,
            @PathVariable("b")
            String password){
        System.out.println("用户名：" + username + "，密码：" + password);
        return "ok";
    }

    // 当前端发送的请求路径是 /user/login ，并且发送的请求方式是以POST方式请求的。则可以正常映射。
    // 当前端发送的请求路径不是 /user/login，请求方式是POST，不会映射到这个方法上。
    // 当前端发送的请求路径是 /user/login，请求方式不是POST，也不会映射到这个方法上。
    //@RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @PostMapping("/user/login")
    public String userLogin(){
        System.out.println("处理登录的业务......");
        return "ok";
    }

    // 当请求路径是 /testParams，并且提交的参数包括 username 和 password时，才能映射成功。
    @RequestMapping(value = "/testParams", params = {"username", "password"})
    //@RequestMapping(value = "/testParams", params = {"username=zhangsan", "password"})
    //@RequestMapping(value = "/testParams", params = {"username!=zhangsan", "password"})
    //@RequestMapping(value = "/testParams", params = {"!username", "password"})
    public String testParams(){
        return "ok";
    }


    // 只有当请求路径是 /testHeaders，并且请求头当中有 Referer 和 Host，这样才能映射成功。
    //@RequestMapping(value = "/testHeaders", headers = {"Referer", "Host"})
    //@RequestMapping(value = "/testHeaders", headers = {"!Referer", "Host"})
    @RequestMapping(value = "/testHeaders", headers = {"Referer=http://localhost:8888/springmvc/", "Host"})
    //@RequestMapping(value = "/testHeaders", headers = {"Referer!=http://localhost:8080/springmvc/", "Host"})
    public String testHeaders(){
        return "ok";
    }


}


























