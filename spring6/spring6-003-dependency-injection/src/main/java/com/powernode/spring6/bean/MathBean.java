package com.powernode.spring6.bean;

/**
 * @author 动力节点
 * @version 1.0
 * @className MathBean
 * @since 1.0
 **/
public class MathBean {
    private String result;

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "MathBean{" +
                "result='" + result + '\'' +
                '}';
    }
}
