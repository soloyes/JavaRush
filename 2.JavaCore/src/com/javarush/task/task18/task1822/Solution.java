package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        try(FileReader fileReader = new FileReader(s);
        BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line;
            for (;(line = bufferedReader.readLine()) != null;){
                if (line.substring(0, line.indexOf(" ")).equals(args[0])){
                    System.out.println(line);
                }
            }
        }
        catch (Exception e){
            e.getMessage();
        }
    }
}
