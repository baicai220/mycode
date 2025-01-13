package com.powernode.factory.method;

/**
 * 抽象工厂角色
 * @author 动力节点
 * @version 1.0
 * @className WeaponFactory
 * @since 1.0
 **/
abstract public class WeaponFactory {

    /**
     * 这个方法不是静态的。是实例方法。
     * @return
     */
    public abstract Weapon get();

}
