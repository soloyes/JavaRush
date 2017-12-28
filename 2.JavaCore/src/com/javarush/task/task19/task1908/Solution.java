package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader2 = new BufferedReader(new FileReader(reader.readLine()));
            BufferedWriter writer1 = new BufferedWriter(new FileWriter(reader.readLine()))){

            String[] s = reader2.readLine().split(" ");
            for (String x: s) {
                try {
                    writer1.write(String.valueOf(Integer.parseInt(x)));
                    writer1.write(" ");
                }
                catch (NumberFormatException e){}
            }
        }
        catch (IOException e){
            e.getMessage();
        }
    }
}
