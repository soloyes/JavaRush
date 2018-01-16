package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

class test implements Cloneable{
    int a = 0;
    boolean b = false;
    FileInputStream c = new FileInputStream("/home/sol/test");

    test() throws FileNotFoundException {
    }

    public static void main(String[] args) throws CloneNotSupportedException, FileNotFoundException {
        test test = new test();
        test clone = (test) test.clone();
        System.out.println("" + test.c + " " + test.a);
        System.out.println("" + clone.c + " " + clone.a);
    }

    public Object clone() throws CloneNotSupportedException {
       test clone = (test) super.clone();
       clone.a = 1;
       return clone;
    }
}