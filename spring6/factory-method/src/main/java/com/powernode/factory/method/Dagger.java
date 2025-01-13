package com.powernode.factory.method;

/**
 * 具体产品角色
 * @author 动力节点
 * @version 1.0
 * @className Dagger
 * @since 1.0
 **/
public class Dagger extends Weapon{

    @Override
    public void attack() {
        System.out.println("砍丫的！！！");
    }
}
