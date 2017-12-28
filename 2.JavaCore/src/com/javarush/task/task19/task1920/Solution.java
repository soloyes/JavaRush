package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        Map<String, Double> map = new TreeMap<>();

        for(;reader.ready();){
            String[] s = reader.readLine().split(" ");
            if (map.get(s[0]) == null) map.put(s[0], Double.parseDouble(s[1]));
            else {
                map.put(s[0], map.get(s[0]) + Double.parseDouble(s[1]));
            }
        }

        Double a = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getValue();
        for (Map.Entry s: map.entrySet()) {
            if (s.getValue().equals(a)) System.out.println(s.getKey());
        }
        reader.close();
    }
}
