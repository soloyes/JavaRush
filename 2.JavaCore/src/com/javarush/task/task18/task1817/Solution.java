package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int count = 0;
        int sCount = 0;
        for (; fileInputStream.available() > 0;) {
            count++;
            if (fileInputStream.read() == 32) sCount ++;
        }
        System.out.println(String.format("%.2f",(float)sCount/count*100));
        fileInputStream.close();
    }
}
