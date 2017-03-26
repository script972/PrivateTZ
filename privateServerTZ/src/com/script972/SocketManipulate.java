package com.script972;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.in;

/**
 * Created by script972 on 23.03.2017.
 */
public class SocketManipulate extends Thread {
    public  void connecting() throws IOException {

            ServerSocket serverSocket=null;
            int port=145;
            try {
                serverSocket = new ServerSocket(port);
                serverSocket.accept();
                System.out.println("connect OK");
            } catch (IOException e) {
                System.out.println("Ошибка коннекта");
            }
            System.out.println("waiting client");
            Socket socket=serverSocket.accept();
            System.out.println("Someone connecting");
            System.out.println();
            InputStream cin=socket.getInputStream();
            OutputStream cout=socket.getOutputStream();


            DataInputStream in=new DataInputStream(cin);
            DataOutputStream out=new DataOutputStream(cout);
            String line=null;





            ProcessingComand processingComand=new ProcessingComand();/* OBJECT DO COMAND*/
            while (true){
                line=in.readUTF();
                System.out.println("Клиент прислал "+ line);
                line=line.toLowerCase();
                String function=line.split("<")[0];
                String argument= (line.split("<")[1]).split(">")[0];
                System.out.println("function " + function);
                System.out.println("argument "+argument);


                switch (function){
                    case "list":
                        processingComand.list(); break;
                    case "sum":
                        processingComand.sum(); break;
                    case "count":
                        processingComand.count(); break;



                }

                out.writeUTF(line+" Обратная строка");
                out.flush();
                System.out.println("Next Connection");
            }
        }


    public void run() {
        try {
            connecting();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

