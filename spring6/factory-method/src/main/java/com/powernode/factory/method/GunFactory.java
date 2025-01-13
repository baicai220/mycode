package com.powernode.factory.method;

/**
 * 具体工厂角色
 * @author 动力节点
 * @version 1.0
 * @className GunFactory
 * @since 1.0
 **/
public class GunFactory extends WeaponFactory{
    @Override
    public Weapon get() {
        return new Gun();
    }
}
