package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader2 = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter writer1 = new BufferedWriter(new FileWriter(reader.readLine()))){

            String c;
            for (;reader2.ready();){
               if (!(c = String.valueOf(
                       (char)reader2.read()).replaceAll(
                       "[\\pP]|[\n]","")).equals("")) writer1.write(c);
            }
        }
        catch (IOException e){
            e.getMessage();
        }
    }
}
