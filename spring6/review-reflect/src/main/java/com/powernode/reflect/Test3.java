package com.powernode.reflect;

import java.lang.reflect.Method;

/**
 * @author 动力节点
 * @version 1.0
 * @className Test3
 * @since 1.0
 **/
public class Test3 {
    public static void main(String[] args) throws Exception{
        // 获取类
        Class<?> clazz = Class.forName("com.powernode.reflect.SomeService");
        // 获取方法
        Method doSomeMethod = clazz.getDeclaredMethod("doSome");
        // 调用方法
        Object obj = clazz.newInstance();
        doSomeMethod.invoke(obj);
    }
}
