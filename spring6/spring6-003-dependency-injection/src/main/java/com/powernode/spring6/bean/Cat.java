package com.powernode.spring6.bean;

/**
 * @author 动力节点
 * @version 1.0
 * @className Cat
 * @since 1.0
 **/
public class Cat {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
