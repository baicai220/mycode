package com.powernode.simple.factory;

/**
 * 具体产品角色
 * @author 动力节点
 * @version 1.0
 * @className Fighter
 * @since 1.0
 **/
public class Fighter extends Weapon{
    @Override
    public void attack() {
        System.out.println("战斗机抛下小男孩！！！！");
    }
}
