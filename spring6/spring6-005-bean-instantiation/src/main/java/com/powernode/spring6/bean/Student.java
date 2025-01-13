package com.powernode.spring6.bean;

import java.util.Date;

/**
 * @author 动力节点
 * @version 1.0
 * @className Student
 * @since 1.0
 **/
public class Student {

    // java.util.Date 在Spring当中被当做简单类型。 但是简单类型的话，注入的日期字符串格式有要求。
    // java.util.Date 在Spring当中也可以被当做非简单类型。
    private Date birth;

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "birth=" + birth +
                '}';
    }
}
