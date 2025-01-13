package com.powernode.client;

import com.powernode.annotation.Component;

/**
 * @author 动力节点
 * @version 1.0
 * @className ReflectAnnotationTest1
 * @since 1.0
 **/
public class ReflectAnnotationTest1 {
    public static void main(String[] args) throws Exception{
        // 通过反射机制怎么读取注解
        // 获取类
        Class<?> aClass = Class.forName("com.powernode.bean.User");
        // 判断类上面有没有这个注解
        if (aClass.isAnnotationPresent(Component.class)) {
            // 获取类上的注解
            Component annotation = aClass.getAnnotation(Component.class);
            // 访问注解属性
            System.out.println(annotation.value());
        }
    }
}
