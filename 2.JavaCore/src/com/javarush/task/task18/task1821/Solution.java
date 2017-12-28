package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        Map<Integer, Integer> a = new TreeMap<>();
        for (;fileInputStream.available() > 0;){
            Integer b = fileInputStream.read();
            if (a.containsKey(b)){

                a.replace(b, a.get(b) + 1);
            }
            else a.put(b, 1);
        }
        for (Map.Entry<Integer, Integer> x: a.entrySet()
             ) {
            System.out.println((char) x.getKey().byteValue() + " " + x.getValue());
        }
        fileInputStream.close();
    }
}
