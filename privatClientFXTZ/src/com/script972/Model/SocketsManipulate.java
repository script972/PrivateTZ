package com.script972.Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.script972.Deposit;

import java.io.*;
import java.lang.reflect.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by script972 on 23.03.2017.
 */
public class SocketsManipulate extends Thread {
    public void connect() throws IOException {
        Socket clientSocket=null;
        int port=145;
        String serv="127.0.0.1";
        try {
            clientSocket=new Socket("localhost", 145);
        } catch (IOException e) {
            System.out.println("error");
        }


        ObjectOutputStream out=new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream in =  new ObjectInputStream(clientSocket.getInputStream());

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        System.out.println("Type in something and press enter. Will send it to the server and tell ya what it thinks.");
        ArrayList<Deposit> arrayList=new ArrayList<>();
        java.lang.reflect.Type type= new TypeToken<ArrayList<Deposit>>(){}.getType();


        while (true){
            line=keyboard.readLine();
            if(line.contains("add")){
                String str=addDepositObject();
                out.writeUTF(line+"<"+str+">");
                out.flush();
            }else {
                out.writeUTF(line);
                out.flush();
            }
            try {
                String recponce= (String) in.readObject();
                System.out.println(recponce);
                Gson gson=new Gson();
                if(recponce.contains("{") && recponce.contains("}") && !recponce.equals(null)) {
                    arrayList = gson.fromJson(recponce, type);
                    System.out.println("array " + arrayList.get(0));
                }else
                {
                    System.out.println(recponce);
                }


            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    private String addDepositObject() throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input bank Name: ");
        String bankName=bufferedReader.readLine();
        System.out.println("Input country: ");
        String country=bufferedReader.readLine();
        System.out.println("Input type number: ");
        System.out.println("-------- 0:"+ Type.CALCULATED);
        System.out.println("-------- 1:"+ Type.ONDEMANDE);
        System.out.println("-------- 2:"+ Type.CUMULATIVE);
        System.out.println("-------- 3:"+ Type.METAL);
        System.out.println("-------- 4:"+ Type.SAVINGS);
        System.out.println("-------- 5:"+ Type.TERMINATE);
        System.out.println("different other:"+ Type.CALCULATED);
        Type type;
        int typeNumber= Integer.parseInt(bufferedReader.readLine());
        switch (typeNumber){
            case 0:type=Type.CALCULATED; break;
            case 1:type=Type.ONDEMANDE; break;
            case 2:type=Type.CUMULATIVE; break;
            case 3:type=Type.METAL; break;
            case 4:type=Type.SAVINGS; break;
            case 5:type=Type.TERMINATE; break;
            default: type=Type.CALCULATED;
        }
        System.out.println("Input depositor: ");
        String depositor=bufferedReader.readLine();
        System.out.println("Input account id:");
        int account_id= Integer.parseInt(bufferedReader.readLine());
        System.out.println("Input amount: ");
        double amount= Double.parseDouble(bufferedReader.readLine());
        System.out.println("Input profitable: ");
        int profitalbe=Integer.parseInt(bufferedReader.readLine());
        System.out.println("Input time: ");
        int time=Integer.parseInt(bufferedReader.readLine());

        Deposit deposit=new Deposit(bankName, country, type, depositor, account_id, amount, profitalbe, time);
        Gson gson=new Gson();
        return gson.toJson(deposit);

    }

    public void run(){
        try {
            connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
