package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine(),true);
            FileInputStream fileInputStream1 = new FileInputStream(reader.readLine());
            FileInputStream fileInputStream2 = new FileInputStream(reader.readLine());

            for (;fileInputStream1.available() > 0;){
                fileOutputStream.write(fileInputStream1.read());
            }

            for (;fileInputStream2.available() > 0;){
                fileOutputStream.write(fileInputStream2.read());
            }

            fileOutputStream.close();
            fileInputStream1.close();
            fileInputStream2.close();
        }
        catch (Exception e){
            e.getMessage();
        }
    }
}
