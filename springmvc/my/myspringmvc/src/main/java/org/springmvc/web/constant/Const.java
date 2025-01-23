package org.springmvc.web.constant;

/**
 * ClassName: Const
 * Description: Spring MVC框架的系统常量类，所有的常量全部放到该常量类中。
 * Datetime: 2024/4/3 11:17
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public class Const {

    /**
     * web.xml文件中配置DispatcherServlet的初始化参数的 contextConfigLocation 的名字。
     */
    public static final String CONTEXT_CONFIG_LOCATION = "contextConfigLocation";

    /**
     * contextConfigLocation的前缀
     */
    public static final String PREFIX_CLASSPATH = "classpath:";

    /**
     * webApplicationContext
     */
    public static final String WEB_APPLICATION_CONTEXT = "webApplicationContext";

    /**
     * HandlerMapping和HandlerAdapter实现类都在这个默认的包下。
     */
    public static final String DEFAULT_PACKAGE = "org.springmvc.web.servlet.mvc.method.annotation";

    /**
     * springmvc.xml文件中的component-scan标签中的 base-package 属性名
     */
    public static final String BASE_PACKAGE = "base-package";

    /**
     * .class结尾
     */
    public static final String SUFFIX_CLASS = ".class";

    /**
     * SPRINGMVC配置文件中bean标签的class属性。
     */
    public static final String BEAN_TAG_CLASS_ATTRIBUTE = "class";

    /**
     * property标签的名字。
     */
    public static final String PROPERTY_TAG_NAME = "property";

    public static final String PROPERTY_NAME = "name";

    public static final String PROPERTY_VALUE = "value";

    public static final String VIEW_RESOLVER = "viewResolver";

    public static final String INTERCEPTORS = "interceptors";

    public static final String HANDLER_MAPPING = "handlerMapping";

    public static final String HANDLER_ADAPTER = "handlerAdapter";
}
