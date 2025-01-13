package com.powernode.simple.factory;

/**
 * 具体产品角色
 * @author 动力节点
 * @version 1.0
 * @className Tank
 * @since 1.0
 **/
public class Tank extends Weapon{
    @Override
    public void attack() {
        System.out.println("坦克开炮！！！");
    }
}
