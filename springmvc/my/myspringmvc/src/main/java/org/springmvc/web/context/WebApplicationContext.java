package org.springmvc.web.context;

import jakarta.servlet.ServletContext;
import org.springmvc.context.ApplicationContext;

/**
 * ClassName: WebApplicationContext
 * Description:
 * Datetime: 2024/4/3 11:49
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public class WebApplicationContext extends ApplicationContext {
    private ServletContext servletContext;
    private String springMvcConfigPath;

    public WebApplicationContext(ServletContext servletContext, String springMvcConfigPath) {
        super(springMvcConfigPath);
        this.servletContext = servletContext;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public String getSpringMvcConfigPath() {
        return springMvcConfigPath;
    }

    public void setSpringMvcConfigPath(String springMvcConfigPath) {
        this.springMvcConfigPath = springMvcConfigPath;
    }
}
