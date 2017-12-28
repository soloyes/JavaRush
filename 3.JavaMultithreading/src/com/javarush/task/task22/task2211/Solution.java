package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(args[0]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);

        Charset w1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        byte[] r = new byte[50];
        for (;fileInputStream.available() > 0;){
            int i = fileInputStream.read(r);
            byte[] w = new byte[i];
            System.arraycopy(r, 0, w, 0, i);
            String k = new String(w, w1251);
            String s = new String(k.getBytes(), utf8);
            fileOutputStream.write(s.getBytes());
        }
    }
}
