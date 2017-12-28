package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            FileReader fileReader = new FileReader(reader.readLine());
            StringBuilder s = new StringBuilder();
            String c;
            int cnt = 0;
            for (;fileReader.ready();){
                if (!(c = String.valueOf(
                        (char)fileReader.read()).replaceAll(
                                "[,]|[.]|[:]|[;]|[?]|[!]|[-]|[\"]|[']|[(]|[)]|[\\[]|[\\]]|[{]|[}]|[\n]|[ ]","")).equals("")) s.append(c);
                else {
                    if (s.toString().equals("world")) cnt ++;
                    s.delete(0, s.length());
                }
            }

            System.out.println(cnt);

            fileReader.close();
        }
        catch (IOException e){
            e.getMessage();
        }
    }
}
