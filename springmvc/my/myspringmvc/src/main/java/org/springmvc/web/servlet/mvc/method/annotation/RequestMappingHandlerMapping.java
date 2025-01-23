package org.springmvc.web.servlet.mvc.method.annotation;

import jakarta.servlet.http.HttpServletRequest;
import org.springmvc.web.constant.Const;
import org.springmvc.web.context.WebApplicationContext;
import org.springmvc.web.method.HandlerMethod;
import org.springmvc.web.servlet.HandlerExecutionChain;
import org.springmvc.web.servlet.HandlerInterceptor;
import org.springmvc.web.servlet.HandlerMapping;
import org.springmvc.web.servlet.mvc.RequestMappingInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: RequestMappingHandlerMapping
 * Description:
 *  处理器映射器，专门为 @RequestMapping 注解服务器处理器映射器
 *  通过前端提交的“请求”，来映射底层要执行的 HandlerMethod。
 *
 *  前端提交的“请求”包括：请求路径，请求方式。
 *
 * Datetime: 2024/4/3 9:51
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public class RequestMappingHandlerMapping implements HandlerMapping {

    /**
     * 处理器映射器，主要就是通过以下的map集合进行映射。
     * key是：请求信息
     * value是：该请求对应要执行的处理器方法
     */
    private Map<RequestMappingInfo, HandlerMethod> map;

    /**
     * 在创建 HandlerMapping对象的时候，给 map 集合赋值。
     * @param map
     */
    public RequestMappingHandlerMapping(Map<RequestMappingInfo, HandlerMethod> map) {
        this.map = map;
    }

    @Override
    public HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {

        // 通过request对象，获取请求路径，获取请求方式，将其封装成RequestMappingInfo对象。
        RequestMappingInfo requestMappingInfo = new RequestMappingInfo(request.getServletPath(), request.getMethod());

        // 创建处理器执行链对象
        HandlerExecutionChain handlerExecutionChain = new HandlerExecutionChain();

        // 给执行链设置HandlerMethod
        handlerExecutionChain.setHandler(map.get(requestMappingInfo));

        // 获取所有拦截器
        WebApplicationContext webApplicationContext = (WebApplicationContext) request.getServletContext().getAttribute(Const.WEB_APPLICATION_CONTEXT);

        // 给执行链设置拦截器
        List<HandlerInterceptor> interceptors = (List<HandlerInterceptor>)webApplicationContext.getBean(Const.INTERCEPTORS);
        handlerExecutionChain.setInterceptors(interceptors);

        return handlerExecutionChain;
    }
}
