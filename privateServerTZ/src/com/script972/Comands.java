package com.script972;

/**
 * Created by script972 on 26.03.2017.
 */
public interface Comands {
    void list();
    void sum();
    void count();
    void infoAccount(int accoutndId);
    void depositor(String deposit);
    void showType(Type type);
    void showBank(String bank);
    String add(Deposit deposit);
    void delete(int accoutndId);

}
