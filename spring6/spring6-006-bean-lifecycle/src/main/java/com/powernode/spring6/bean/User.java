package com.powernode.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 *
 * Bean的生命周期按照粗略的五步的话：
 * 第一步：实例化Bean（调用无参数构造方法。）
 * 第二步：给Bean属性赋值（调用set方法。）
 * 第三步：初始化Bean（会调用Bean的init方法。注意：这个init方法需要自己写，自己配。）
 * 第四步：使用Bean
 * 第五步：销毁Bean（会调用Bean的destroy方法。注意：这个destroy方法需要自己写，自己配。）
 *
 * @author 动力节点
 * @version 1.0
 * @className User
 * @since 1.0
 **/
public class User implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean {

    private String name;

    public void setName(String name) {
        System.out.println("第二步：给对象的属性赋值。");
        this.name = name;
    }

    public User() {
        System.out.println("第一步：无参数构造方法执行。");
    }

    // 这个方法需要自己写，自己配。方法名随意。
    public void initBean(){
        System.out.println("第四步：初始化Bean。");
    }

    // 这个方法需要自己写，自己配。方法名随意。
    public void destroyBean(){
        System.out.println("第七步：销毁Bean。");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("Bean这个类的加载器：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("生产这个Bean的工厂对象是：" + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("这个Bean的名字是：" + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean's afterPropertiesSet执行。");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean's destroy方法执行");
    }
}
