package com.powernode.springmvc.bean;

/**
 * ClassName: User
 * Description:
 * Datetime: 2024/3/27 23:05
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public class User {
    private String username;
    private String password;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
