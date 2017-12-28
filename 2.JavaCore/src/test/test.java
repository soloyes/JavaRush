package test;

import java.io.FileInputStream;

class test implements Cloneable{
    int a = 0;
    boolean b = false;
    FileInputStream c = null;
    public static void main(String[] args) throws CloneNotSupportedException
    {
        test test = new test();
        test clone = (test) test.clone();
        System.out.println(test.c);
        System.out.println(clone.c);
    }

}