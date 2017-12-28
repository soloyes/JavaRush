package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static int ID;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        ArrayList<String> list = new ArrayList<>();

        BufferedReader reader1 = new BufferedReader(new FileReader(fileName));

        while (reader1.ready()) {
            list.add(reader1.readLine());
        }

        reader1.close();
        if (args.length != 0) {
            if (args[0].equals("-u")) {
                String arg1 = args[1].length() > 8 ? args[1].substring(0, 8) : args[1];
                String arg2 = args[2].length() > 30 ? args[2].substring(0, 30) : args[2];
                String arg3 = args[3].length() > 8 ? args[3].substring(0, 8) : args[3];
                String arg4 = args[4].length() > 4 ? args[4].substring(0, 4) : args[4];

                rmLine(list, arg1);

                list.add(ID, String.format("%-8s%-30s%-8s%-4s", arg1, arg2, arg3, arg4));

                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                for (int i = 0; i < list.size(); i++) {
                    writer.write(list.get(i));
                    writer.write("\n");
                }
                writer.close();
            } else if (args[0].equals("-d")) {
                rmLine(list, args[1]);
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                for (int i = 0; i < list.size(); i++) {
                    writer.write(list.get(i));
                    writer.write("\n");
                }
                writer.close();
            }
        }
    }

    private static void rmLine(ArrayList<String> list, String id){
        int i = 0;
        for (String x : list){
            if (x.substring(0,8).trim().equals(id)) break;
            i ++;
        }
        list.remove(i);
        ID = i;
    }
}
