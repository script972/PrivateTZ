package com.script972.Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by script972 on 23.03.2017.
 */
public class SocketsManipulate extends Thread {
    public void connect() throws IOException {
        Socket clientSocket=null;
        int port=1450;
        String serv="127.0.0.1";
        try {
            clientSocket=new Socket("localhost", port);
        } catch (IOException e) {
            System.out.println("error");
        }

        PrintWriter out=new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()),true);
        BufferedReader in =  new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        System.out.println("Type comand for server.");
        ArrayList<Deposit> arrayList;
        java.lang.reflect.Type type= new TypeToken<ArrayList<Deposit>>(){}.getType();


        while (true){
            line=keyboard.readLine();
            if(line.equals("EXIT:0")){
                out.println("EXIT:0");
                out.flush();
                break;
            }
            if(line.equals("add")){
                String str=addDepositObject();
                out.println(line+"<"+str+">");
                out.flush();
            }else {
                out.println(line);
                out.flush();
            }

                String recponce= (String) in.readLine();
                Gson gson=new Gson();
                if(recponce.contains("{") && recponce.contains("}") && !recponce.equals(null)) {
                    arrayList = gson.fromJson(recponce, type);
                    arrOut(arrayList);
                }else
                {
                    System.out.println(recponce);
                }



        }
        in.close();
        out.close();
        clientSocket.close();

    }

    private void arrOut(ArrayList<Deposit> arrayList) {
        for (Deposit dep :
                arrayList) {
            System.out.println(dep);
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
        System.out.println(deposit);
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
