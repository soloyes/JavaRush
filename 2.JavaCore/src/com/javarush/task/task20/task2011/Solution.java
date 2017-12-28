package com.javarush.task.task20.task2011;

import java.io.*;

/*
Externalizable для апартаментов
*/
public class Solution {

    public static class Apartment implements Externalizable{

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeObject(this.address);
            objectOutput.writeInt(this.year);
        }

        @Override
        public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
            this.address = (String) objectInput.readObject();
            this.year = objectInput.readInt();
        }
    }

    public static void main(String[] args) throws IOException {
        Apartment apartment = new Apartment();
        FileOutputStream fileOutputStream = new FileOutputStream("/home/sol/test");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        apartment.address = "St";
        apartment.year = 10;
        apartment.writeExternal(objectOutputStream);
    }
}
