package com.script972;

import java.math.BigInteger;

/**
 * Created by script972 on 23.03.2017.
 */
public class Deposit {
    String Name;
    String country;
    Type type;
    String Deposit;
    int account_id;
    BigInteger money;
    byte persent;
    int time_constraints;

    public Deposit(String name, String country, Type type, String deposit, int account_id, BigInteger money, byte persent, int time_constraints) {
        Name = name;
        this.country = country;
        this.type = type;
        Deposit = deposit;
        this.account_id = account_id;
        this.money = money;
        this.persent = persent;
        this.time_constraints = time_constraints;
    }
}
