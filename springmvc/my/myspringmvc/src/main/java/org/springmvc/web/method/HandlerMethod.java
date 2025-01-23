package org.springmvc.web.method;

import java.lang.reflect.Method;

/**
 * ClassName: HandlerMethod
 * Description: 处理器方法
 * Datetime: 2024/4/3 9:52
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public class HandlerMethod {
    /**
     * 真正的处理器对象
     */
    private Object handler;
    /**
     * 处理器方法
     */
    private Method method;

    public Object getHandler() {
        return handler;
    }

    public void setHandler(Object handler) {
        this.handler = handler;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public HandlerMethod() {
    }

    public HandlerMethod(Object handler, Method method) {
        this.handler = handler;
        this.method = method;
    }
}
