package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            FileReader fileReader = new FileReader(file1);
            FileWriter fileWriter = new FileWriter(file2);

            for(;fileReader.ready();){
                fileReader.read();
                int c;
                if ((c = fileReader.read()) > 0) fileWriter.write(c);
            }
            fileReader.close();
            fileWriter.close();
        }
        catch (IOException e){
            e.getMessage();
        }
    }
}
