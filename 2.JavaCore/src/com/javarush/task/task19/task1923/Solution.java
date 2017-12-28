package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileWriter fileWriter = new FileWriter(args[1]);

        for (;reader.ready();) {
            String[] s = reader.readLine().split(" ");
            for (String value : s) {
                if (value.matches(".*\\d+.*")) {
                    fileWriter.write(value);
                    fileWriter.write(" ");
                }
            }
        }
        reader.close();
        fileWriter.close();
    }
}
