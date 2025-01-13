package com.powernode.spring6.bean;

/**
 * 这是一个Bean，封装了用户的信息。Spring可以帮助我们创建User对象吗？
 * @author 动力节点
 * @version 1.0
 * @className User
 * @since 1.0
 **/
public class User {
    // Spring是怎么实例化对象的？
    // 默认情况下Spring会通过反射机制，调用类的无参数构造方法来实例化对象。
    // 实现原理如下：
    // Class clazz = Class.forName("com.powernode.spring6.bean.User");
    // Object obj = clazz.newInstance();
    public User() {
        System.out.println("User的无参数构造方法执行。");
    }

    public User(String s){

    }
}
