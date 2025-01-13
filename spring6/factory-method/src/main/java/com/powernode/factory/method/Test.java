package com.powernode.factory.method;

/**
 * 客户端程序
 * @author 动力节点
 * @version 1.0
 * @className Test
 * @since 1.0
 **/
public class Test {
    public static void main(String[] args) {
        WeaponFactory weaponFactory = new DaggerFactory();
        Weapon dagger = weaponFactory.get();
        dagger.attack();

        WeaponFactory weaponFactory1 = new GunFactory();
        Weapon gun = weaponFactory1.get();
        gun.attack();
    }
}
