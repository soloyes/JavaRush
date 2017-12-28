package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        for (;reader.ready();){
            String s = reader.readLine();
            String name = s.replaceAll("[\\d]", "").trim();
            String birthDay = s.replaceAll("^\\D+", "");
            System.out.println(name + " " + birthDay);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
            PEOPLE.add(new Person(name, simpleDateFormat.parse(birthDay)));
        }
        reader.close();
    }
}
