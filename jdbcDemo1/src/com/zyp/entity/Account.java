package com.zyp.entity;

import java.io.Serializable;

/**
 * @Auther: TianWei_18811580953
 * @Date: 2022/11/21 - 11 - 21 - 23:11
 * @Description: com.zyp.entity
 * @version: 1.0
 */
public class Account implements Serializable {

        private int aid;
        private String username;
        private String password;
        private int money;

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}';
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Account() {
    }

    public Account(int aid, String username, String password, int money) {
        this.aid = aid;
        this.username = username;
        this.password = password;
        this.money = money;
    }
}
