package com.script972.Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by script972 on 27.03.2017.
 */
public class SeverSocketDo {
    private ServerSocket server;
    private int port=1450;

    public SeverSocketDo() {
        try {
            server=new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleConncetion(){
        System.out.println("waiting for client comand....");
        while (true){
            try {
                Socket socket = server.accept();
                new ConnectionHandler(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
