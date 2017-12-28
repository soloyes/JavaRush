package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());

            FileOutputStream fileOutputStream1 = new FileOutputStream(reader.readLine());
            FileOutputStream fileOutputStream2 = new FileOutputStream(reader.readLine());

            int count1 = fileInputStream.available() / 2;
            int count2 = (fileInputStream.available() % 2 == 0) ? count1 : count1 + 1;

            for (int i = 0; i < count2; i++) {
                fileOutputStream1.write(fileInputStream.read());
            }

            for (int i = 0; i < count1; i++) {
                fileOutputStream2.write(fileInputStream.read());
            }

            fileInputStream.close();
            fileOutputStream1.close();
            fileOutputStream2.close();
        }
        catch (Exception e){
            e.getMessage();
        }
    }
}
