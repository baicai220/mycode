package com.powernode.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author 动力节点
 * @version 1.0
 * @className Test2
 * @since 1.0
 **/
public class Test2 {
    public static void main(String[] args) throws Exception{
        // 使用反射机制怎么调用方法。
        // 获取类
        Class<?> clazz = Class.forName("com.powernode.reflect.SomeService");

        // 获取方法
        Method doSomeMethod = clazz.getDeclaredMethod("doSome", String.class, int.class);

        // 调用方法
        // 四要素：调用哪个对象、哪个方法、传什么参数、返回什么值。
        // obj 要素：哪个对象
        // doSomeMethod 要素：哪个方法
        // "李四", 250 要素：传什么参数
        // retValue 要素：返回什么值。
        Object obj = clazz.newInstance();
        Object retValue = doSomeMethod.invoke(obj, "李四", 250);
        System.out.println(retValue);
    }
}
