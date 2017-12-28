package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            byte a = 0;
            int b;
            for (;fileInputStream.available() > 0;){
                if ((b = fileInputStream.read()) > a) a = (byte) b;
            }
            System.out.println(a);
            reader.close();
            fileInputStream.close();
        }

    }
}
