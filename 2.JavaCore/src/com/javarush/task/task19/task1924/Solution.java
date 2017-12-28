package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));

        for (;reader1.ready();){
            String[] s = reader1.readLine().split(" ");
            for (String x : s) {
                Integer i = null;
                try{
                    i = Integer.parseInt(x);
                }
                catch (NumberFormatException e){ }
                if(map.get(i) != null) System.out.print(map.get(Integer.parseInt(x)) + " ");
                else System.out.print(x + " ");
            }
            System.out.println();
        }

        reader.close();
        reader1.close();
    }
}
