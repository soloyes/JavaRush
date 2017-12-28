package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream stream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream1 = new PrintStream(byteArrayOutputStream);

        System.setOut(stream1);

        testString.printSomething();

        String result = byteArrayOutputStream.toString();

        System.setOut(stream);

        StringBuilder stringBuilder = new StringBuilder(result.replaceAll("[t]{1}[e]{1}", "??"));

        System.out.println(stringBuilder.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
