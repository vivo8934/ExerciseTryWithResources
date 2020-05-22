package com.readingFiles;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Main {

    public static void main(String[] args) throws Exception {
       // doTryCatchFinally();
        doTryWithResources();
       // doCloseThing();
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
    public static void doTryWithResources(){
        char[] buff = new char[10];
        int length;
        try (Reader reader = Helper.openReader("file1.txt");
             Writer writer = Helper.openWriter("file2.txt")){
            while ((length = reader.read(buff)) >= 0){
                System.out.println("\nlength: " + length);
                writer.write(buff, 0, length);
            }
        }catch (IOException e){
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
    private static void doCloseThing() throws Exception {
        try (MyAutoCloseable ac = new MyAutoCloseable()){
            ac.saySomething();
        }catch (IOException e){
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());

            for (Throwable t : e.getSuppressed()){
                System.out.println("Suppressed: " + t.getMessage());
            }
        }
    }

}
