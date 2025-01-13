package com.powernode.bean;

import com.powernode.annotation.Component;

/**
 * @author 动力节点
 * @version 1.0
 * @className User
 * @since 1.0
 **/

//@Component(属性名 = 属性值, 属性名 = 属性值, 属性名 = 属性值....)
//@Component(value = "userBean")
// 如果属性名是value，value可以省略。
@Component("userBean")
public class User {

    // 编译器报错，不能出现在这里。
    //@Component(value = "test")
    //private String name;
}
