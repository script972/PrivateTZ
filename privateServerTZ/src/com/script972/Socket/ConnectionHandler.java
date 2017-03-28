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

        System.out.println("some one connectiong");
        System.out.println("among connect  "+conectors);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            String responce;


            while (true) {
                String comand = objectInputStream.readUTF();
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
                objectOutputStream.writeObject(responce);

                /*Gson gson=new Gson();
                ArrayList<Deposit> arrayList=new ArrayList();
                arrayList.add(new Deposit("Депозит 1", "Страна", Type.CALCULATED, "Депозит", 3, 33333, 22, 323232));
                arrayList.add(new Deposit("Депозит 2", "Страна", Type.SAVINGS, "Депозит", 3, 33333, 1, 32));
                String json=gson.toJson(arrayList);*/




            }






        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
