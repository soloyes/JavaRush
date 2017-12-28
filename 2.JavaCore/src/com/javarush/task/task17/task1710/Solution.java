package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        SimpleDateFormat dateFormatPrt = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        if (args.length != 0) {
            Person person;
            Date date = null;
            switch (args[0]) {
                case "-c":
                        try {
                            date = dateFormat.parse(args[3]);
                        } catch (ParseException e) {
                           e.getMessage();
                        }
                        if (args[2].startsWith("м"))
                            person = Person.createMale(args[1], date);
                        else
                            person = Person.createFemale(args[1], date);

                        synchronized (allPeople) {
                            allPeople.add(person);
                        }
                        System.out.println(allPeople.indexOf(person));
                    break;

                case "-u":
                    synchronized (allPeople) {
                            int index = Integer.parseInt(args[1]);
                            person = allPeople.get(index);

                            person.setName(args[2]);

                            try {
                                date = dateFormat.parse(args[4]);
                            } catch (ParseException e) {
                                e.getMessage();
                            }
                            person.setBirthDay(date);

                            if (args[3].startsWith("м"))
                                person.setSex(Sex.MALE);
                            else
                                person.setSex(Sex.FEMALE);
                    }
                    break;

                case "-d": {
                    synchronized (allPeople) {
                            int index = Integer.parseInt(args[1]);
                            person = allPeople.get(index);
                            person.setName(null);
                            person.setSex(null);
                            person.setBirthDay(null);
                    }
                    break;
                }

                case "-i":
                    synchronized (allPeople) {
                            person = allPeople.get(Integer.parseInt(args[1]));
                            StringBuffer s = new StringBuffer();
                            s.append(person.getName());
                            s.append(" ");
                            s.append(person.getSex() == Sex.MALE ? "м" : "ж");
                            s.append(" ");
                            s.append(dateFormatPrt.format(person.getBirthDay()));
                            System.out.println(s);
                        }
                        break;
            }
        }
    }
}
