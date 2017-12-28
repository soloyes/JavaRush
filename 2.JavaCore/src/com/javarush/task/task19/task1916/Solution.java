package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));

        boolean s1Flag = true;
        boolean s2Flag = true;
        String s1 = null;
        String s2 = null;
        for (; ; ) {
            if (s1Flag) s1 = reader1.readLine();
            if (s2Flag) s2 = reader2.readLine();

            if (s1 == null) {
                lines.add(new LineItem(Type.ADDED, s2));
                break;
            }
            if (s2 == null) {
                lines.add(new LineItem(Type.REMOVED, s1));
                break;
            }
            if (s1.equals(s2)) {
                lines.add(new LineItem(Type.SAME, s1));
                s1Flag = true;
                s2Flag = true;
                continue;
            }
            reader2.mark(10000000);
            if (s1.equals(reader2.readLine())) {
                lines.add(new LineItem(Type.ADDED, s2));
                s1Flag = false;
                reader2.reset();
                continue;
            }

            reader2.reset();
            reader1.mark(10000000);
            if (reader1.readLine().equals(s2)) {
                lines.add(new LineItem(Type.REMOVED, s1));
                s2Flag = false;
                reader1.reset();
            }
        }

        reader1.close();
        reader2.close();

//        for (LineItem x: lines
//             ) {
//            System.out.println(x.type + " " + x.line);
//        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
