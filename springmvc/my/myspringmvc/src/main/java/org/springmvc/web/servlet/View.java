package org.springmvc.web.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

/**
 * ClassName: View
 * Description: 视图接口
 * Datetime: 2024/4/3 9:57
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public interface View {

    /**
     * 获取内容类型的
     * @return
     */
    String getContentType();

    /**
     * 渲染
     * @param model
     * @param request
     * @param response
     * @throws Exception
     */
    void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
