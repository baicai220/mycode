package com.powernode.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * ClassName: RequestScopeTestController
 * Description:
 * Datetime: 2024/3/26 22:18
 * Author: 老杜@动力节点
 * Version: 1.0
 */
@Controller
public class RequestScopeTestController {

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){

        // 将共享的数据存储到request域当中
        request.setAttribute("testRequestScope", "在SpringMVC当中使用原生Servlet API完成request域数据共享");

        // 跳转视图，在视图页面将request域中的数据取出来，这样就完成了：Controller和View在同一个请求当中两个组件之间数据的共享。
        // 这个跳转，默认情况下是：转发的方式。（转发forward是一次请求）
        // 这个返回的是一个逻辑视图名称，经过视图解析器解析，变成物理视图名称。/WEB-INF/thymeleaf/ok.html
        return "ok";
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        // 向request域当中绑定数据
        model.addAttribute("testRequestScope", "在SpringMVC当中使用Model接口完成request域数据共享");
        System.out.println(model);
        System.out.println(model.getClass().getName());
        // 转发
        return "ok";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        // 向request域当中存储数据
        map.put("testRequestScope", "在SpringMVC当中使用Map接口完成request域数据共享");
        System.out.println(map);
        System.out.println(map.getClass().getName());
        // 转发
        return "ok";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        // 向request域当中存储数据
        modelMap.addAttribute("testRequestScope", "在SpringMVC当中使用ModelMap类完成request域数据共享");
        System.out.println(modelMap);
        System.out.println(modelMap.getClass().getName());
        // 转发
        return "ok";
    }


    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        // 创建 模型视图 对象
        ModelAndView mav = new ModelAndView();
        // 给 模型视图对象 绑定数据
        mav.addObject("testRequestScope", "在SpringMVC当中使用ModelAndView类完成request域数据共享");
        // 给 模型视图对象 绑定视图（绑定逻辑视图名称）
        mav.setViewName("ok");
        // 返回 模型视图对象
        return mav;
    }

}



















