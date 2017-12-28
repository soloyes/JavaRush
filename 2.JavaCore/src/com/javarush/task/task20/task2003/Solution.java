package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            load(fileInputStream);
        }
        catch (Exception e){
            e.getMessage();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties properties = new Properties();
        properties.putAll(Solution.properties);
        properties.store(outputStream, "test");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties properties = new Properties();
        properties.load(inputStream);
        for (String name : properties.stringPropertyNames()){
            Solution.properties.put(name, properties.getProperty(name));
        }
    }

    public static void main(String[] args) {

    }
}
