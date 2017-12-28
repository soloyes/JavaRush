package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Solution s = new Solution();
        fullArrays();
        try{
            s.joinData();
        }
        catch (CorruptedDataException e){
            e.getMessage();
        }
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }

    private static void fullArrays(){
        String file1 = "";
        String file2 = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            file1 = reader.readLine();
            file2 = reader.readLine();
            reader.close();
        }
        catch (IOException e){
            e.getMessage();
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file1)))){
            String line;
            for (;((line = reader.readLine()) != null);){
                allLines.add(line);
            }
            reader.close();

        } catch (IOException e){
            e.getMessage();
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file2)))){
            String line;
            for (;((line = reader.readLine()) != null);){
                forRemoveLines.add(line);
            }
            reader.close();

        } catch (IOException e){
            e.getMessage();
        }
    }
}
