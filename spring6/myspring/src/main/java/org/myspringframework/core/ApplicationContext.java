package org.myspringframework.core;

/**
 * MySpring框架应用上下文接口。
 * @author 动力节点
 * @version 1.0
 * @className ApplicationContext
 * @since 1.0
 **/
public interface ApplicationContext {

    /**
     * 根据bean的名称获取对应的bean对象。
     * @param beanName myspring配置文件中bean标签的id。
     * @return 对应的单例bean对象。
     */
    Object getBean(String beanName);

}
