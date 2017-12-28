package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    private FileOutputStream fileOutputStream;
    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.fileOutputStream = fileOutputStream;
    }

    public static String fileName = "/home/sol/test";

    @Override
    public void write(int i) throws IOException {
        this.fileOutputStream.write(i);
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        fileOutputStream.write(bytes);
    }

    @Override
    public void write(byte[] bytes, int i, int i1) throws IOException {
        fileOutputStream.write(bytes, i, i1);
    }

    @Override
    public void close() throws IOException {
        flush();
        fileOutputStream.write("JavaRush © All rights reserved.".getBytes());
        this.fileOutputStream.close();
    }

    @Override
    public void flush() throws IOException {
        this.fileOutputStream.flush();
    }

    public static void main(String[] args) throws IOException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
