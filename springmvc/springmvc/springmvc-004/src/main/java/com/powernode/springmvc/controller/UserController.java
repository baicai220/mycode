package com.powernode.springmvc.controller;

import com.powernode.springmvc.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * ClassName: UserController
 * Description:
 * Datetime: 2024/3/26 15:33
 * Author: 老杜@动力节点
 * Version: 1.0
 */
@Controller
public class UserController {

    @RequestMapping("/")
    public String toRegister(){
        // 返回一个逻辑视图
        return "register";
    }

    //@RequestMapping(value = "/user/reg", method = RequestMethod.POST)
    /*@PostMapping("/user/reg")
    public String register(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        // HttpServletRequest、HttpServletResponse、HttpSession都属于原生Servlet API。
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);

        // 获取请求提交的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String[] interest = request.getParameterValues("interest"); // interest=smoke&interest=drink&interest=tt
        String intro = request.getParameter("intro");

        System.out.println(username);
        System.out.println(password);
        System.out.println(sex);
        System.out.println(Arrays.toString(interest));
        System.out.println(intro);

        return "ok";
    }*/

    /*@PostMapping("/user/reg")
    public String register(
            //@RequestParam(value = "username") // value可以，name也可以
            //@RequestParam(name = "username") // username 不能随便写，最好是复制过来的。
            @RequestParam(name = "username") // 如果前端没有提供 uname 参数，则报错：400
            String a, // 变量名随意
            @RequestParam(value = "password")
            String password,
            @RequestParam("sex")
            Integer sex, // SpringMVC也可以自动帮助我们做类型转换，从前端提交的是'0'/'1'字符串，可以自动转换成Integer类型。
            @RequestParam("interest")
            String[] interest,
            @RequestParam("intro")
            String intro,
            @RequestParam(value = "age", required = false, defaultValue = "20")
            Integer age){

        System.out.println(a);
        System.out.println(password);
        System.out.println(sex);
        System.out.println(Arrays.toString(interest));
        System.out.println(intro);
        System.out.println("年龄：" + age);
        return "ok";
    }*/

    /*@PostMapping("/user/reg")
    public String register(String uname, String password, Integer sex, String[] interest, String intro, Integer age){
        System.out.println(uname); // null（因为前端没有提交这个数据）
        System.out.println(password);
        System.out.println(sex);
        System.out.println(Arrays.toString(interest));
        System.out.println(intro);
        System.out.println(age);
        return "ok";
    }*/

    /*@PostMapping("/user/reg")
    public String register(String uname, String password, Integer sex, String interest, String intro, Integer age){
        System.out.println(uname); // null（因为前端没有提交这个数据）
        System.out.println(password);
        System.out.println(sex);
        System.out.println(interest);
        System.out.println(intro);
        System.out.println(age);
        return "ok";
    }*/


    //@PostMapping("/user/reg")
    /*@RequestMapping("/user/reg")
    public String register(User user,
                           @RequestHeader(value = "Referer", required = false, defaultValue = "")
                           String referer,
                           @RequestHeader(value = "Host", required = false, defaultValue = "")
                           String host,
                           @CookieValue(value = "id", required = false, defaultValue = "")
                           String id){
        System.out.println(user);
        System.out.println(referer);
        System.out.println(host);
        System.out.println("客户端提交过来的cookie，它的值是：" + id);
        return "ok";
    }*/

    @RequestMapping("/user/reg")
    public String register(User user, HttpServletRequest request) throws UnsupportedEncodingException {
        // 设置请求体的字符编码方式，解决POST请求乱码问题
        //request.setCharacterEncoding("UTF-8");

        System.out.println(user);
        return "ok";
    }

}
