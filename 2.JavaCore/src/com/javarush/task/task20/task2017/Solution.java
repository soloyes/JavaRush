package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
//        Object o = objectStream.readObject();
//        if (o.getClass() != A.class)
//        return null;
//        return (A) o;
        try {
            return (A) objectStream.readObject();
        } catch (Exception e) {
            new B();
            return null;
        }
    }

    public class A implements Serializable{
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
