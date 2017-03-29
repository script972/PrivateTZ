package com.script972;

import com.google.gson.Gson;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Objects;


/**
 * Created by script972 on 26.03.2017.
 */
public class ProcessingComand implements Comands {
    ArrayList<Deposit> arrayList=new ArrayList<>();
    FilesSeril filesSeril;

    public ProcessingComand() {
        filesSeril=new FilesSeril();
        arrayList=filesSeril.getDeposits();

    }

    @Override
    public String list() {
        return arrToStr(arrayList);
    }

    @Override
    public String sum() {
        System.out.println("Обработка SUM");
        BigDecimal summ=new BigDecimal(0);
        for (Deposit dep :
                arrayList) {
            summ=summ.add(BigDecimal.valueOf(dep.getMoney()));
        }
        System.out.println(summ);

        return String.valueOf(summ);
    }

    @Override
    public String count() {
        return String.valueOf(arrayList.size());
    }

    @Override
    public String infoAccount(int accoutndId) {
        System.out.println("обработка infoacc ID");
        Deposit out;
        ArrayList<Deposit> arr=new ArrayList<>();
        for (Deposit dep :
                arrayList) {
            if (dep.getAccount_id() == accoutndId)
                arr.add(dep);
        }
        if(arr.isEmpty())
            return "not Found";
        return arrToStr(arr);
    }

    @Override
    public String infoDepositor(String deposit) {
        System.out.println("обработка Depositor");
        ArrayList<Deposit> arr=new ArrayList<>();
        for (Deposit dep :
                arrayList) {
            if (Objects.equals(dep.getDeposit(), deposit)) {
                arr.add(dep);
            }
        }
        if(arr.isEmpty())
            return "not Found";
        return arrToStr(arr);

    }

    @Override
    public String showType(String type) {
        System.out.println("Обработка show Type");
        ArrayList<Deposit> arr=new ArrayList<>();
        for (Deposit dep :
                arrayList) {
            if (Objects.equals(dep.getType().toString(), type.toString())) {
                arr.add(dep);
            }
        }
        if(arr.isEmpty())
            return "not Found";
        return arrToStr(arr);
    }

    @Override
    public String showBank(String bank) {
        System.out.println("Обоаотка show Bank "+bank );
        ArrayList<Deposit> arr=new ArrayList<>();
        for (Deposit dep :
                arrayList) {
            if (dep.getName().equals(bank)) {
                arr.add(dep);
            }
        }
        if(arr.isEmpty())
            return "not Found";
        return arrToStr(arr);
    }

    @Override
    public String add(String deposit) {
        System.out.println("Обработка depositor");
        Gson gson = new Gson();
        Deposit depObject=gson.fromJson(deposit, Deposit.class);
        if(depObject.getMoney()<=0)
            return "Money <=0";
        if(depObject.getPersent()<=0)
            return "Persent <=0";
        if(depObject.getTime_constraints()<=0)
            return "time deposit <=0";
        for (Deposit dep:
             arrayList) {
            if(dep.getAccount_id()==depObject.getAccount_id())
                return "This ID already exist";

        }
        arrayList.add(depObject);
        filesSeril.setDeposits(arrayList);
        filesSeril.saveFile();
        return "OK";
    }

    @Override
    public String delete(int accoutndId) {
        System.out.println("Обработка delete argument: "+accoutndId);
        boolean is=false;
        for (Deposit dep :
                arrayList) {
            if (dep.account_id==accoutndId) {
                is=true;
                arrayList.remove(dep);
                break;
            }
        }
        if(is==false)
            return "Такого account ID не существует";
        System.out.println("После удаления "+arrayList);
        filesSeril.setDeposits(arrayList);
        filesSeril.saveFile();
        return "delete OK";

    }

    private String arrToStr(ArrayList<Deposit> arrayList){
        Gson gson=new Gson();
        String json=gson.toJson(arrayList);
        return json;
    }

    public String comandDo(String function, String argument){
        String result = null;
/*        System.out.println("function "+function);
        System.out.println("argument "+argument);*/
        switch (function){
            case "list":result=list(); break;
            case "sum": result=sum(); break;
            case "count": result=count(); break;
            case "info account":{
                result=infoAccount(Integer.parseInt(argument));
                break;
            }
            case "info depositor":{
                result=infoDepositor(argument);
                break;
            }
            case "show type":{
                result=showType(argument);
                break;
            }
            case "show bank":{
                result=showBank(argument);
                break;
            }
            case "add":{
                result=add(argument);
                break;
            }
            case "delete":{
                result=delete(Integer.parseInt(argument));
                break;
            }
            default: result="comand not found";
        }
        return result;
    }
}
