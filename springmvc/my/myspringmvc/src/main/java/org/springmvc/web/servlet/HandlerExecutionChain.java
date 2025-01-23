package org.springmvc.web.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * ClassName: HandlerExecutionChain
 * Description: 处理器执行链
 * Datetime: 2024/4/3 9:49
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public class HandlerExecutionChain {
    /**
     * 处理器方法：实际上底层对象是 HandlerMethod对象。
     */
    private Object handler;

    /**
     * 本次请求需要执行的拦截器
     */
    private List<HandlerInterceptor> interceptors;

    /**
     * 当前拦截器执行到哪个拦截器了，当前拦截器的下标
     */
    private int interceptorIndex = -1;

    public HandlerExecutionChain(Object handler, List<HandlerInterceptor> interceptors) {
        this.handler = handler;
        this.interceptors = interceptors;
    }

    public HandlerExecutionChain() {
    }

    public Object getHandler() {
        return handler;
    }

    public void setHandler(Object handler) {
        this.handler = handler;
    }

    public List<HandlerInterceptor> getInterceptors() {
        return interceptors;
    }

    public void setInterceptors(List<HandlerInterceptor> interceptors) {
        this.interceptors = interceptors;
    }

    public int getInterceptorIndex() {
        return interceptorIndex;
    }

    public void setInterceptorIndex(int interceptorIndex) {
        this.interceptorIndex = interceptorIndex;
    }

    /**
     * 执行所有拦截器的preHandle方法
     * @param request
     * @param response
     * @return
     */
    public boolean applyPreHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 遍历拦截器（顺序遍历）
        for (int i = 0; i < interceptors.size(); i++) {
            // 取出每一个拦截器对象
            HandlerInterceptor handlerInterceptor = interceptors.get(i);
            // 调用preHandle方法
            boolean result = handlerInterceptor.preHandle(request, response, handler);
            // 根据执行结果，如果为false表示不再继续执行。
            if(!result){
                // 执行拦截器的afterCompletion方法
                triggerAfterCompletion(request, response, null);
                return false;
            }
            interceptorIndex = i;
        }
        return true;
    }

    /**
     * 按照逆序的方式执行拦截器中的postHandle方法
     * @param request
     * @param response
     * @param mv
     */
    public void applyPostHandle(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws Exception {
        for (int i = interceptors.size() - 1; i >= 0; i--) {
            HandlerInterceptor handlerInterceptor = interceptors.get(i);
            handlerInterceptor.postHandle(request, response, handler, mv);
        }
    }

    /**
     * 按照逆序的方式执行拦截器的afterCompletion方法
     * @param request
     * @param response
     * @param o
     */
    public void triggerAfterCompletion(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        for (int i = interceptorIndex; i >= 0; i--) {
            HandlerInterceptor handlerInterceptor = interceptors.get(i);
            handlerInterceptor.afterCompletion(request, response, handler, null);
        }
    }

}
