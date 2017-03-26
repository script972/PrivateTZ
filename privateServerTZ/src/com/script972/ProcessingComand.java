package com.script972;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Created by script972 on 26.03.2017.
 */
public class ProcessingComand implements Comands {

    @Override
    public void list() {
        FilesSeril filesSeril=new FilesSeril();
        filesSeril.getFile();
    }

    @Override
    public void sum() {
        System.out.println("Обработка SUM");

    }

    @Override
    public void count() {
        System.out.println("Обработка count");

    }

    @Override
    public void infoAccount(int accoutndId) {
        System.out.println("обработка acc ID");

    }

    @Override
    public void depositor(String deposit) {
        System.out.println("обработка Depositor");
    }

    @Override
    public void showType(Type type) {
        System.out.println("Обработка show Type");
    }

    @Override
    public void showBank(String bank) {
        System.out.println("Обоаотка show Bank");
    }

    @Override
    public String add(Deposit deposit) {
        System.out.println("Обработка depositor");
        return null;
    }

    @Override
    public void delete(int accoutndId) {
        System.out.println("Обработка delete");

    }
}
