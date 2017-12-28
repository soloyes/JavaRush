package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static volatile Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        for (;;) {
            String s = null;
            try  {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                s = reader.readLine();
                if (s.equals("exit")) {
                    break;
                }
            } catch (Exception e) {
                e.getMessage();
            }
            //System.out.println(s);
            ReadThread readThread = new ReadThread(s);
            readThread.start();
        }

//        for (Map.Entry<String, Integer> x : resultMap.entrySet()){
//            System.out.println(x.getKey() + " " + x.getValue());
//        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            Map<Integer, Integer> a = new TreeMap<>();

            try {
                for (;fileInputStream.available() > 0;){
                    //System.out.println(Thread.currentThread().getName());
                    Integer b = fileInputStream.read();
                    if (a.containsKey(b)){

                        a.replace(b, a.get(b) + 1);
                    }
                    else a.put(b, 1);
                }

//                for (Map.Entry<Integer, Integer> x : a.entrySet()){
//                    System.out.println(x.getKey() + " " + x.getValue());
//                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Integer max = Collections.max(a.entrySet(), Map.Entry.comparingByValue()).getKey();
            resultMap.put(fileName, max);
        }
    }
}
