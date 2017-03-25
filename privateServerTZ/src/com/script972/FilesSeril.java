package com.script972;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by script972 on 25.03.2017.
 */
public class FilesSeril {
    private ArrayList<Deposit> deposits=new ArrayList<>();

    /*Save object to SERIALIZE FILE*/
    public void saveFile(){
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(
                    new FileOutputStream("Deposits.ser")));
            out.writeObject(deposits);
        } catch ( IOException ex ) {
            ex.printStackTrace();
        } finally {
            if ( out != null )
                try {
                    out.close();
                } catch ( IOException ex ) {
                    ex.printStackTrace();
                }
        }
    }

    public void getFile(){
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(
                    new FileInputStream("Deposits.ser")));
            deposits = (ArrayList)in.readObject();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        } catch ( Exception ex ) {
            ex.printStackTrace();
        } finally {
            if ( in != null )
                try {
                    in.close();
                } catch ( IOException ex ) {
                    ex.printStackTrace();
                }
        }
    }

    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(ArrayList<Deposit> deposits) {
        this.deposits = deposits;
    }

    /*Print all object*/
    public void systemOutList() {
        for (Deposit item :
                deposits) {
            System.out.println(item);
        }
    }
}
