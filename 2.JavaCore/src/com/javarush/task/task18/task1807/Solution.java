package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());

            while (fileInputStream.available() > 0){
                if (fileInputStream.read() == 44){
                    count ++;
                }
            }
            fileInputStream.close();
        }
        catch (Exception e){
            e.getMessage();
        }
        System.out.println(count);
    }
}
