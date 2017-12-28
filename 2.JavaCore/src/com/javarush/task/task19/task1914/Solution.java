package com.javarush.task.task19.task1914;

/* 
Решаем пример
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

        String[] s = result.split(" ");
        String res = " = ";
        String sign = "";
        if (s[1].equals("+")){
            res += Integer.parseInt(s[0]) + Integer.parseInt(s[2]);
            sign = " + ";
        }
        else if (s[1].equals("-")){
            res += Integer.parseInt(s[0]) - Integer.parseInt(s[2]);
            sign = " - ";
        }
        else if (s[1].equals("*")){
            res += Integer.parseInt(s[0]) * Integer.parseInt(s[2]);
            sign = " * ";
        }

        System.out.println(s[0] + sign + s[2] + res);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

