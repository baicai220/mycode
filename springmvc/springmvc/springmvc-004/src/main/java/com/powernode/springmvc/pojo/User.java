package com.powernode.springmvc.pojo;

import java.util.Arrays;

/**
 * ClassName: User
 * Description:
 * Datetime: 2024/3/26 17:17
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public class User {
    private Long id;
    private String a;
    private String b;
    private Integer c;
    private String[] d;
    private String e;
    private Integer f;

    public User() {
    }

    public User(Long id, String username, String password, Integer sex, String[] interest, String intro, Integer age) {
        this.id = id;
        this.a = username;
        this.b = password;
        this.c = sex;
        this.d = interest;
        this.e = intro;
        this.f = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return a;
    }

    public void setUsername(String username) {
        this.a = username;
    }

    /*public void setUname(String username) {
        this.a = username;
    }*/

    public String getPassword() {
        return b;
    }

    public void setPassword(String password) {
        this.b = password;
    }

    public Integer getSex() {
        return c;
    }

    public void setSex(Integer sex) {
        this.c = sex;
    }

    public String[] getInterest() {
        return d;
    }

    public void setInterest(String[] interest) {
        this.d = interest;
    }

    public String getIntro() {
        return e;
    }

    public void setIntro(String intro) {
        this.e = intro;
    }

    public Integer getAge() {
        return f;
    }

    public void setAge(Integer age) {
        this.f = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + a + '\'' +
                ", password='" + b + '\'' +
                ", sex=" + c +
                ", interest=" + Arrays.toString(d) +
                ", intro='" + e + '\'' +
                ", age=" + f +
                '}';
    }
}
