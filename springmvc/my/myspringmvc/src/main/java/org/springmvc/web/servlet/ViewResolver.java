package org.springmvc.web.servlet;

import java.util.Locale;

/**
 * ClassName: ViewResolver
 * Description: 视图解析器接口
 * Datetime: 2024/4/3 9:55
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public interface ViewResolver {

    /**
     * 视图解析，将逻辑视图名转换为物理视图名，并且返回视图对象。
     * @param viewName
     * @param locale
     * @return
     * @throws Exception
     */
    View resolveViewName(String viewName, Locale locale) throws Exception;
}
