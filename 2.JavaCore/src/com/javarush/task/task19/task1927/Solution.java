package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream stream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream1 = new PrintStream(byteArrayOutputStream);

        System.setOut(stream1);
        testString.printSomething();

        System.setOut(stream);

        String[] s = byteArrayOutputStream.toString().split("\n");
        int i = 0;
        for (String s1:s) {
            if (i % 2 == 0 && i !=0) System.out.println("JavaRush - курсы Java онлайн");
            i ++;
            System.out.println(s1);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
