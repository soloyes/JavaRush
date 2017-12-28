package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String s = fileScanner.nextLine();
            String[] st =  s.split(" ");
            Date d = new Date(Integer.valueOf(st[6]), Integer.valueOf(st[5]), Integer.valueOf(st[4]));
            return new Person(st[0], st[1], st[2], d);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
