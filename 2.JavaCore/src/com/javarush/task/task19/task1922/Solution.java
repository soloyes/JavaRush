package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        for (;reader1.ready();){
            String s = reader1.readLine();
            List<String> l = Arrays.asList(s.split(" "));
            int i = 0;
            for (String x:words) {
                if (l.contains(x)) i ++;
            }
            if (i == 2) {
                System.out.println(s);
            }
        }

        reader1.close();
    }
}
