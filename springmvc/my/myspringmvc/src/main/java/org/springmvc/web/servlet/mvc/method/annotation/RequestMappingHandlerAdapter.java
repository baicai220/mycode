package org.springmvc.web.servlet.mvc.method.annotation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springmvc.ui.ModelMap;
import org.springmvc.web.method.HandlerMethod;
import org.springmvc.web.servlet.HandlerAdapter;
import org.springmvc.web.servlet.ModelAndView;

import java.lang.reflect.Method;

/**
 * ClassName: RequestMappingHandlerAdapter
 * Description: 处理器适配器，专门为 @RequestMapping 注解准备的处理器适配器。
 * Datetime: 2024/4/3 9:54
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public class RequestMappingHandlerAdapter implements HandlerAdapter {
    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 需要调用处理器方法的
        HandlerMethod handlerMethod = (HandlerMethod)handler;

        // 获取Controller对象
        Object controller = handlerMethod.getHandler();

        // 获取要调用的方法
        Method method = handlerMethod.getMethod();

        // 通过反射机制调用方法
        // 我们自己写的springmvc框架，有一个特殊的要求，要求Controller类中方法必须有ModelMap参数
        // 我们自己写的springmvc框架，还有一个特殊的要求，要求Controller类中方法必须返回String逻辑视图名字
        ModelMap modelMap = new ModelMap();
        String viewName = (String)method.invoke(controller, modelMap);

        // 封装ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.setModel(modelMap);

        return modelAndView;
    }
}
