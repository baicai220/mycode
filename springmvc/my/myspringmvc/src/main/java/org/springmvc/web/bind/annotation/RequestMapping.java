package org.springmvc.web.bind.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: RequestMapping
 * Description: 请求映射的注解
 * Datetime: 2024/4/3 10:00
 * Author: 老杜@动力节点
 * Version: 1.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {

    /**
     * 支持多个请求路径
     * @return
     */
    String[] value();

    /**
     * 指定请求方式
     * @return
     */
    RequestMethod method();

}
