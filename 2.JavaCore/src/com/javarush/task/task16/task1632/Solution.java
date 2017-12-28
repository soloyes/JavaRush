package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }
    public static void main(String[] args) {

    }

    private static class Thread1 extends Thread {
        @Override
        public void run(){
            for (;;){}
        }
    }
    private static class Thread2 extends Thread {
        @Override
        public void run(){
            for (;;){
                try{Thread2.sleep(1);}
                catch (InterruptedException e){
                    System.out.println("InterruptedException");
                }
            }
        }
    }
    private static class Thread3 extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {

            }
        }
    }
    private static class Thread4 extends Thread implements Message{

        @Override
        public void run(){

                if (!isInterrupted()){
                    for (;;){}
                }

        }

        @Override
        public void showWarning() {
            interrupt();
        }

    }
    private static class Thread5 extends Thread {
        @Override
        public void run(){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String tmp = "0";
            Integer res = 0;
            try {
                for (;!(tmp = reader.readLine()).equals("N");){
                    res += Integer.parseInt(tmp);
                }
                System.out.println(res);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}