package org.springmvc.web.servlet;

import jakarta.servlet.http.HttpServletRequest;

/**
 * ClassName: HandlerMapping
 * Description: 处理器映射器（根据请求路径映射到HandlerMethod上）
 * Datetime: 2024/4/3 9:49
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public interface HandlerMapping {

    /**
     * 根据请求返回处理器执行链对象。
     * @param request 请求对象
     * @return 处理器执行链对象
     * @throws Exception
     */
    HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception;
}
