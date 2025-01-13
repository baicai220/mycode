package com.powernode.factory.method;

/**
 * 具体工厂角色
 * @author 动力节点
 * @version 1.0
 * @className DaggerFactory
 * @since 1.0
 **/
public class DaggerFactory extends WeaponFactory{
    @Override
    public Weapon get() {
        return new Dagger();
    }
}
