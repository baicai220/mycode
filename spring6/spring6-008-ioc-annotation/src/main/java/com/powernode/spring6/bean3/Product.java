package com.powernode.spring6.bean3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 动力节点
 * @version 1.0
 * @className User
 * @since 1.0
 **/
@Component
public class Product {

    /*@Value("隔壁老王")
    private String name;
    @Value("30")
    private int age;*/

    private String name;
    private int age;

    public Product(@Value("隔壁老王3") String name, @Value("42") int age) {
        this.name = name;
        this.age = age;
    }

    // @Value注解也可以使用在方法上。
    /*@Value("隔壁老王2")
    public void setName(String name) {
        this.name = name;
    }

    @Value("33")
    public void setAge(int age) {
        this.age = age;
    }*/

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
