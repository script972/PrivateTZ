package com.script972.Model;

import java.io.*;
import java.net.Socket;

/**
 * Created by script972 on 23.03.2017.
 */
public class SocketsManipulate {
    public void connect() throws IOException {
        Socket clientSocket=null;
        int port=145;
        String serv="127.0.0.1";
        try {
            clientSocket=new Socket("localhost", 145);
        } catch (IOException e) {
            System.out.println("error");
        }

        InputStream sin = clientSocket.getInputStream();
        OutputStream sout = clientSocket.getOutputStream();


        DataInputStream in = new DataInputStream(sin);
        DataOutputStream out = new DataOutputStream(sout);

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        System.out.println("Type in something and press enter. Will send it to the server and tell ya what it thinks.");
        System.out.println();

        while (true){
            line=keyboard.readLine();
            out.writeUTF(line);
            out.flush();
            line=in.readUTF();
            System.out.println("Ответ от сервера таков "+line);
        }
    }
}
