package com.script972;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.in;

/**
 * Created by script972 on 23.03.2017.
 */
public class SocketManipulate {
    public  void connecting() throws IOException {

            ServerSocket serverSocket=null;
            int port=145;
            try {
                serverSocket = new ServerSocket(port);
                serverSocket.accept();
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
            while (true){
                line=in.readUTF();
                System.out.println("Клиент прислал "+ line);
                out.writeUTF(line+" Обратная строка");
                out.flush();
                System.out.println("Next Connection");
            }
        }
    }

