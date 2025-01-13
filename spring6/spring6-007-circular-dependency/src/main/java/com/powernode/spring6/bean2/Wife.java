package com.powernode.spring6.bean2;

/**
 * 妻子类
 * @author 动力节点
 * @version 1.0
 * @className Wife
 * @since 1.0
 **/
public class Wife {
    private String name;
    private Husband husband;

    public Wife(String name, Husband husband) {
        this.name = name;
        this.husband = husband;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "name='" + name + '\'' +
                ", husband=" + husband.getName() +
                '}';
    }
}
