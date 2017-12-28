package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileWriter fileWriter = new FileWriter(args[1]);

        int i = 0;
        for (;reader.ready();){
            String[] s = reader.readLine().split(" ");
            for (String x:s) {
                if(x.length() > 6) {
                    if (i != 0) fileWriter.write(",");
                    fileWriter.write(x);
                    i ++;
                }
            }
        }

        reader.close();
        fileWriter.close();
    }
}
