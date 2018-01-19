package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<Throwable> throwables = new ArrayList<>();
        throwables.add(e);
        Throwable throwable = e.getCause();
        try{
            while (true){
                throwables.add(throwable);
                throwable = throwable.getCause();
            }
        }catch (NullPointerException e1){
            for (int i = throwables.size() - 2; i >= 0 ; i--) {
                System.out.println(throwables.get(i).toString());
            }
        }
    }

    public static void main(String[] args) {
        Solution.Test t = new Solution().new Test();
        t.start();
    }

    private class Test extends Thread{
        Test(){
            this.setUncaughtExceptionHandler(new Solution());
        }

        @Override
        public void run() {
            throw new RuntimeException("BLA", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        }
    }
}
