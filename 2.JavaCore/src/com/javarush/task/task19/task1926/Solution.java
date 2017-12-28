package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        for(;bf.ready();){
            StringBuilder s = new StringBuilder(bf.readLine());
            System.out.println(s.reverse());
        }

        bf.close();
    }
}
