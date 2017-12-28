package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String file1 = reader.readLine();
            FileInputStream fileInputStream2 = new FileInputStream(reader.readLine());
            FileInputStream fileInputStream1 = new FileInputStream(file1);
            byte[] bytes = new byte[fileInputStream1.available()];
            fileInputStream1.read(bytes);
            FileOutputStream fileOutputStream = new FileOutputStream(file1);
            for (;fileInputStream2.available() > 0;){
                fileOutputStream.write(fileInputStream2.read());
            }
            fileOutputStream.close();

            fileOutputStream = new FileOutputStream(file1, true);
            fileOutputStream.write(bytes);

            fileOutputStream.close();
            fileInputStream1.close();
            fileInputStream2.close();
        }
        catch (Exception e){
            e.getMessage();
        }

    }
}
