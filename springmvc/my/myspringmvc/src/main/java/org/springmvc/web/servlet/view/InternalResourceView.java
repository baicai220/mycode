package org.springmvc.web.servlet.view;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springmvc.web.servlet.View;

import java.util.Map;

/**
 * ClassName: InternalResourceView
 * Description: 视图接口的实现类。
 * Datetime: 2024/4/3 9:57
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public class InternalResourceView implements View {

    /**
     * 响应的内容类型
     */
    private String contentType;

    /**
     * 响应的路径
     */
    private String path;

    public InternalResourceView() {
    }

    public InternalResourceView(String contentType, String path) {
        this.contentType = contentType;
        this.path = path;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 设置响应的内容类型
        response.setContentType(contentType);
        // 将model数据存储到request域当中（默认情况下，数据是存储在request域当中的。）
        model.forEach(request::setAttribute);
        // 转发（默认情况下，跳转到视图是以转发的方式）
        request.getRequestDispatcher(path).forward(request, response);
    }
}
