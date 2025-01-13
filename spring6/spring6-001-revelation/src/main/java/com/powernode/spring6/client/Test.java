package com.powernode.spring6.client;

import com.powernode.spring6.web.UserAction;

/**
 * @author 动力节点
 * @version 1.0
 * @className Test
 * @since 1.0
 **/
public class Test {
    public static void main(String[] args) {
        UserAction userAction = new UserAction();
        userAction.deleteRequest();
    }
}
