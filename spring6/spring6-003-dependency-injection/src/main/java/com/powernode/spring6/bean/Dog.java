package com.powernode.spring6.bean;

import java.util.Date;

/**
 * @author 动力节点
 * @version 1.0
 * @className Dog
 * @since 1.0
 **/
public class Dog {
    // 简单类型
    private String name;
    private int age;
    // 非简单类型
    private Date birth;

    // p命名空间注入底层还是set注入，只不过p命名空间注入可以让spring配置变的更加简单。
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }
}
