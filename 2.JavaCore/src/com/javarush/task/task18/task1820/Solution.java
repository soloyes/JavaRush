package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String s1 = reader.readLine();
            String s2 = reader.readLine();
            FileInputStream fileInputStream = new FileInputStream(s1);
            FileOutputStream fileOutputStream = new FileOutputStream(s2);

            StringBuilder a = new StringBuilder();
            for (;fileInputStream.available() > 0;){
                a.append(String.valueOf((char)fileInputStream.read()));
            }
            String[] v = a.toString().split(" ");
            StringBuilder b = new StringBuilder();
            for (String x : v){
                b.append(Math.round(Float.valueOf(x))).append(" ");
            }

            byte[] bytes = b.toString().getBytes();

            fileOutputStream.write(bytes);

            fileInputStream.close();
            fileOutputStream.close();
        }
        catch (Exception e){
            e.getMessage();
        }
    }
}
