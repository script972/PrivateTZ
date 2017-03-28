package com.script972;

import com.script972.Socket.SeverSocketDo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 * Created by script972 on 25.03.2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {



        SeverSocketDo severSocketDo=new SeverSocketDo();
        severSocketDo.handleConncetion();








     /*   FilesSeril file=new FilesSeril();
        ArrayList <Deposit> arrayList=new ArrayList<>();
        *//*SocketManipulate socketManipulate=new SocketManipulate();
        socketManipulate.start();*//*

        *//*TO FILE*//*
        arrayList.add(new Deposit("Депозит 1", "Страна", Type.CALCULATED, "Депозит", 3, 33333, 22, 323232));
        arrayList.add(new Deposit("Депозит 2", "Страна2", Type.CUMULATIVE, "Депозит2", 4, 33333, 22, 323232));
        file.setDeposits(arrayList);
        file.saveFile();*/


       /*FROM FILE*/
       /*file.getFile();
       file.systemOutList();*/
    }
}
