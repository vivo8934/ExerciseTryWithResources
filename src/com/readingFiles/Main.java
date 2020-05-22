package com.readingFiles;

import java.io.IOException;
import java.io.Reader;

public class Main {

    public static void main(String[] args) {
        doTryCatchFinally();
    }
    public static void doTryCatchFinally(){
        char[] buff = new char[2];
        int length;

        Reader reader = null;
        try {
            reader = Helper.openReader("file1.txt");
            length = reader.read(buff);
            while (length >=0){
                System.out.println("\nlength: " + length);
                for (int i = 0; i < length; i++){
                    System.out.println(buff[i]);
                }
            }

        }catch (IOException e){
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
        finally {
            try {
                if (reader != null)
                    reader.close();
            }catch (IOException e2){
                System.out.println(e2.getClass().getSimpleName()+ " - " + e2.getMessage());
            }
        }
    }
}
