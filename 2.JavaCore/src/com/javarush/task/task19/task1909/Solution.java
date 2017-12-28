package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader2 = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter writer1 = new BufferedWriter(new FileWriter(reader.readLine()))) {

            for(;reader2.ready();){
                int c;
                if ((c = reader2.read()) == 46) c = 33;
                writer1.write(c);
            }
        }
        catch (IOException e){
            e.getMessage();
        }
    }
}
