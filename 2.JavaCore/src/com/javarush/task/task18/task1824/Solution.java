package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        for (;;){
            String re = null;
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                re = reader.readLine();
                FileInputStream fileInputStream = new FileInputStream(re);
                fileInputStream.close();
            }
            catch (FileNotFoundException e){
                System.out.println(re);
                break;
            }
            catch (IOException e){
                e.getMessage();
            }
        }
    }
}