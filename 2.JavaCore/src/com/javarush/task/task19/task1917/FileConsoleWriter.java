package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.*;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String var1) throws IOException {
        fileWriter = new FileWriter(var1);
    }

    public FileConsoleWriter(String var1, boolean var2) throws IOException {
        fileWriter = new FileWriter(var1, var2);
    }

    public FileConsoleWriter(File var1) throws IOException {
        fileWriter = new FileWriter(var1);
    }

    public FileConsoleWriter(File var1, boolean var2) throws IOException {
        fileWriter = new FileWriter(var1, var2);
    }

    public FileConsoleWriter(FileDescriptor var1) {
        fileWriter = new FileWriter(var1);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        this.fileWriter.write(cbuf, off, len);
        for (int i = 0; i < len; i++) {
            System.out.print(cbuf[off + i]);
        }
    }
    public void write(int c) throws IOException{
        this.fileWriter.write(c);
        System.out.println(c);
    }
    public void write(String str) throws IOException{
        this.fileWriter.write(str);
        System.out.println(str);
    }
    public void write(String str, int off, int len) throws IOException{
            this.fileWriter.write(str, off, len);
            char[] c = str.toCharArray();
            for (int i = 0; i < len; i++) {
                System.out.print(c[off + i]);
            }
    }
    public void write(char[] cbuf) throws IOException{
        this.fileWriter.write(cbuf);
        for (char aCbuf : cbuf) {
            System.out.print(aCbuf);
        }
    }
    public void close() throws IOException{
        this.fileWriter.close();
    }

    public static void main(String[] args) {

    }

}
