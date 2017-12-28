package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream =
                new FileInputStream(
                        new BufferedReader(
                                new InputStreamReader(System.in)).readLine());
        ArrayList<Integer> listData = new ArrayList<>();
        while (inputStream.available() > 0) listData.add(inputStream.read());
        inputStream.close();
        ArrayList<Integer> result = new ArrayList<>(new HashSet<>(listData));

        for (int i = result.size() - 1; i > 0; i --){
            for (int j = 0; j < i; j ++) {
                if (result.get(j) < result.get(j + 1)){
                    int tmp = result.get(j);
                    result.set(j, result.get(j + 1));
                    result.set(j + 1, tmp);
                }
            }
        }

        while (!result.isEmpty()) {
            System.out.print(result.get(result.size()-1) + " ");
            result.remove(result.get(result.size()-1));
        }
    }
}
