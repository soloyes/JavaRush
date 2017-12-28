package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        String tegStart = "<" + args[0];
        String tegEnd   = "</"+ args[0];

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        StringBuffer lines = new StringBuffer();
        for (;fileReader.ready();){
            lines.append(fileReader.readLine());
        }
        String text = lines.toString();
        reader.close();
        fileReader.close();

        Pattern p_start = Pattern.compile(tegStart);
        Pattern p_stop = Pattern.compile(tegEnd);
        Matcher m_start = p_start.matcher(text);
        Matcher m_stop = p_stop.matcher(text);

        Map<Integer, Integer> map = new TreeMap<>();

        for (;m_start.find();){
            map.put(m_start.start(),1);
        }

        for (;m_stop.find();){
            map.put(m_stop.start(), 0);
        }

        ArrayList<Integer> positions = new ArrayList<>(map.keySet());
        ArrayList<Integer> desc = new ArrayList<>(map.values());

        for (int i = 0; i < desc.size() - 1; i++) {
            int c = 1;
            if (desc.get(i) != 1) {
                continue;
            }
            for (int j = i + 1; j < desc.size(); j++) {
                if (desc.get(j) == 1) c++;
                else c--;
                if (c == 0) {
                    System.out.println(text.substring(positions.get(i),positions.get(j) + tegStart.length() + 2));
                    break;
                }
            }
        }
    }
}
