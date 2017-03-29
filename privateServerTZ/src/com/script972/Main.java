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
    }
}
