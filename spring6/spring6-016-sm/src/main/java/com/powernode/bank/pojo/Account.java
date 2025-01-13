package com.powernode.bank.pojo;

/**
 * @author 动力节点
 * @version 1.0
 * @className Account
 * @since 1.0
 **/
public class Account {
    private String actno;
    private Double balance;

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "actno='" + actno + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Account(String actno, Double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
