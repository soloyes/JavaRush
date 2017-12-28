package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        String file = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file = reader.readLine();
        }
        catch (IOException e) {
            e.getMessage();
        }

        PrintStream stream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream1 = new PrintStream(byteArrayOutputStream);

        System.setOut(stream1);

        testString.printSomething();

        String result = byteArrayOutputStream.toString();

        System.setOut(stream);

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)){
            fileOutputStream.write(result.getBytes());
        }
        catch (IOException e){
            e.getMessage();
        }

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

