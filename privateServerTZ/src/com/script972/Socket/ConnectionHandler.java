package com.script972.Socket;

import com.google.gson.Gson;
import com.script972.Deposit;
import com.script972.FilesSeril;
import com.script972.ProcessingComand;
import com.script972.Type;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;


/**
 * Created by script972 on 27.03.2017.
 */
public class ConnectionHandler implements Runnable {
    private Socket socket;
    public static int conectors=0;


    public ConnectionHandler(Socket socket) {
        this.socket = socket;
        Thread t = new Thread(this);
        conectors++;
        t.start();
    }


    @Override
    public void run() {
        System.out.println("someone connecting");
        System.out.println("among connect  "+conectors);
        try {
            BufferedReader objectInputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter objectOutputStream = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

            String responce;
            while (true) {
                String comand = null;
                comand = (String)objectInputStream.readLine();
                if(comand.equals("EXIT:0")){
                    break;
                }
                System.out.println("take a message " + comand);
                String argument = null;
                String function = null;
                if (comand.contains("<")) {
                    function = comand.split("<")[0];
                    argument = (comand.split("<")[1]).split(">")[0];
                    } else
                    {
                        function = comand.split("<")[0];
                    }
                ProcessingComand processingComand=new ProcessingComand();
                responce=processingComand.comandDo(function,argument);
                objectOutputStream.println(responce);
            }
            objectInputStream.close();
            objectOutputStream.close();
            socket.close();
            System.out.println("Conneting closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
