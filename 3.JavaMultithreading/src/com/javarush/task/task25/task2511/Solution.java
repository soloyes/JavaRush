package com.javarush.task.task25.task2511;

import java.util.Timer;
import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = (t, e) -> {
            String name = t.getName();
            String replace = "";
            for (int i = 0; i < name.length(); i++) {
                replace += "*";
            }
            System.out.println(e.getMessage().replaceAll(name, replace));
        };
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
//        Timer timer = new Timer();
//        timer.schedule(new Solution(new TimerTask() {
//            @Override
//            public void run() {
//                throw new ArithmeticException();
//            }
//        }),1);
    }
}