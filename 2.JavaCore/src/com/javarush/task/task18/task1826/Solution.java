package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);

        String a = args[0];
        if (a.equals("-e")){
            for (;fileInputStream.available() > 0;){
                fileOutputStream.write(fileInputStream.read()+1);
            }
        }
        else if (a.equals("-d")){
            for (;fileInputStream.available() > 0;){
                fileOutputStream.write(fileInputStream.read()-1);
            }
        }

        fileInputStream.close();
        fileOutputStream.close();
    }

}
