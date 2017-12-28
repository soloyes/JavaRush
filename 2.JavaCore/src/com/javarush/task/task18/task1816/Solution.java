package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{
        ArrayList<Integer> bytes = new ArrayList<>();
        for (int i = 65,j = 97; i <= 90; i ++, j ++) {
            bytes.add(i);
            bytes.add(j);
        }
        int count = 0;
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        for (;fileInputStream.available() > 0;){
            int a = fileInputStream.read();
            for (Integer aByte : bytes) {
                if (aByte.compareTo(a) == 0) {
                    count++;
                }
            }
        }
        fileInputStream.close();
        System.out.println(count);
    }
}
