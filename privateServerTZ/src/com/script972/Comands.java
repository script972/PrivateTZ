package com.script972;

import java.util.ArrayList;

/**
 * Created by script972 on 26.03.2017.
 */
public interface Comands {
    String list();
    String sum();
    String count();
    String infoAccount(int accoutndId);
    String infoDepositor(String deposit);
    String showType(String type);
    String showBank(String bank);
    String add(String deposit);
    String delete(int accoutndId);

}
