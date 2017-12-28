package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        ArrayList<String> list = new ArrayList<>();

        BufferedReader reader1 = new BufferedReader(new FileReader(fileName));

        while (reader1.ready()) {
            list.add(reader1.readLine());
        }

        if (args[0].equals("-c")) {
            String idOfNewStringInt = getNextId(list);

            String arg1 = args[1].length()>30 ? args[1].substring(0,30) : args[1];
            String arg2 = args[2].length()>8 ? args[2].substring(0,8) : args[2];
            String arg3 = args[3].length()>4 ? args[3].substring(0,4) : args[3];

            list.add(String.format("%-8s%-30s%-8s%-4s", Integer.valueOf(idOfNewStringInt), arg1, arg2, arg3));

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < list.size(); i ++) {
                writer.write(list.get(i));
                writer.write("\n");
            }
            reader.close();
            reader1.close();
            writer.close();
        }
    }

    private static String getNextId(ArrayList<String> list){
        ArrayList<Integer> id = new ArrayList<>();
        for (String x : list){
            id.add(Integer.valueOf(x.substring(0,8).replaceAll(" ", "")));
        }
        Collections.sort(id);
        return String.valueOf(id.get(id.size() - 1) + 1);
    }
}