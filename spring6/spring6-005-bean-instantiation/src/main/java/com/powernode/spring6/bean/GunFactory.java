package com.powernode.spring6.bean;

/**
 * 工厂方法模式当中的：具体工厂角色。
 * @author 动力节点
 * @version 1.0
 * @className GunFactory
 * @since 1.0
 **/
public class GunFactory {

    // 工厂方法模式中的具体工厂角色中的方法是：实例方法。
    public Gun get(){
        // 实际上new这个对象还是我们程序员自己new的。
        return new Gun();
    }
}
