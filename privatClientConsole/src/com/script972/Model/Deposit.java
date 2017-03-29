package com.script972.Model;



import com.script972.Model.Type;

import java.io.Serializable;


/**
 * Created by script972 on 24.03.2017.
 */
public class Deposit implements Serializable {
    String name;
    String country;
    Type type;
    String deposit;
    int account_id;
    double money;
    int persent;
    int time_constraints;

    public Deposit(String name, String country, Type type, String deposit, int account_id, double money, int persent, int time_constraints) {
        this.name = name;
        this.country = country;
        this.type = type;
        this.deposit = deposit;
        this.account_id = account_id;
        this.money = money;
        this.persent = persent;
        this.time_constraints = time_constraints;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", type=" + type +
                ", deposit='" + deposit + '\'' +
                ", account_id=" + account_id +
                ", money=" + money +
                ", persent=" + persent +
                ", time_constraints=" + time_constraints +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getPersent() {
        return persent;
    }

    public void setPersent(int persent) {
        this.persent = persent;
    }

    public int getTime_constraints() {
        return time_constraints;
    }

    public void setTime_constraints(int time_constraints) {
        this.time_constraints = time_constraints;
    }
}
