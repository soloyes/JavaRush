package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Byte[]> b = new TreeMap<>();

        String name = null;
        for (;;) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String re = reader.readLine();
                if (re.equals("end")) {
                    break;
                }
                name = re.substring(0, re.lastIndexOf("."));
                FileInputStream fileInputStream = new FileInputStream(re);

                byte[] bytes = new byte[fileInputStream.available()];
                fileInputStream.read(bytes);
                b.put(re, byteToByte(bytes));

                fileInputStream.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }

        //System.out.println(name);
//        for (Map.Entry<String,Byte[]> x : b.entrySet()){
//            System.out.println(x.getKey() + " " + Arrays.toString(x.getValue()));
//        }

        try {

            FileOutputStream fileOutputStream = new FileOutputStream(name, true);

            for (Map.Entry<String, Byte[]> x : b.entrySet()){
//                System.out.println("d");
                fileOutputStream.write(byteTobyte(x.getValue()));
            }

            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Byte[] byteToByte(byte[] bytes){
        Byte[] b = new Byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            b[i] = bytes[i];
        }
        return b;
    }

    private static byte[] byteTobyte(Byte[] bytes){
        byte[] b = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            b[i] = bytes[i];
        }
        return b;
    }
}
