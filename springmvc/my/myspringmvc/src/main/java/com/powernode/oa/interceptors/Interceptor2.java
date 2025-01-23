package com.powernode.oa.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springmvc.web.servlet.HandlerInterceptor;
import org.springmvc.web.servlet.ModelAndView;

/**
 * ClassName: Interceptor2
 * Description:
 * Datetime: 2024/4/3 10:54
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public class Interceptor2 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Interceptor2's preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Interceptor2's postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Interceptor2's afterCompletion");
    }
}
