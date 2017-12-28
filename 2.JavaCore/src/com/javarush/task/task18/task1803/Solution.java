package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> map = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            for (;fileInputStream.available() > 0;){
                int a = fileInputStream.read();
                if (map.get(a) == null) map.put(a, 1);
                else {
                    int b = map.get(a);
                    b++;
                    map.put(a, b);
                }
            }
            fileInputStream.close();
            reader.close();
        }

        int a = 0;
        for (HashMap.Entry<Integer, Integer> m : map.entrySet()){
            if (m.getValue() > a) a = m.getValue();
        }

        for (HashMap.Entry<Integer, Integer> m : map.entrySet()){
            if (m.getValue() == a) System.out.print(m.getKey() + " ");
        }
    }
}
