package com.powernode.springmvc.filter;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * ClassName: CharacterEncodingFilter
 * Description:
 * Datetime: 2024/3/26 19:59
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public class CharacterEncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 设置请求体的字符集
        request.setCharacterEncoding("UTF-8");
        // 设置响应的字符集
        response.setContentType("text/html;charset=UTF-8");
        // 执行下一个资源
        chain.doFilter(request, response);
    }
}
