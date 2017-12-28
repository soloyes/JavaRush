package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) {
        System.out.println(new Solution(4));
        Solution solution = new Solution(1);
        Solution solution1 = new Solution(2);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/home/sol/test");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(solution);
            fileOutputStream.close();
            objectOutputStream.close();

            FileInputStream fileInputStream = new FileInputStream("/home/sol/test");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            solution1 = (Solution) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
            System.out.println(solution1.temperature + " " + solution1.string + " " + solution1.currentDate);
        }
        catch (IOException e){
            System.out.println("bla");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.getCause();
        }
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
