package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            for (;;){
                FileInputStream fileInputStream = new FileInputStream(reader.readLine());
                if (fileInputStream.available() < 1000) {
                    fileInputStream.close();
                    throw new DownloadException();
                }
                fileInputStream.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static class DownloadException extends Exception {

    }
}
