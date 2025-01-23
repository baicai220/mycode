package org.springmvc.web.servlet.view;

import org.springmvc.web.servlet.View;
import org.springmvc.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * ClassName: InternalResourceViewResolver
 * Description: 内部资源的视图解析器，可以解析JSP。
 * Datetime: 2024/4/3 9:56
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public class InternalResourceViewResolver implements ViewResolver {

    private String prefix;
    private String suffix;

    public InternalResourceViewResolver() {
    }

    public InternalResourceViewResolver(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * 将逻辑视图名字转换成物理视图名称，并以View对象形式返回
     * @param viewName
     * @param locale
     * @return
     * @throws Exception
     */
    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        // 视图解析器，将逻辑视图名称转换为物理视图名称。
        return new InternalResourceView("text/html;charset=UTF-8", prefix + viewName + suffix);
    }
}
