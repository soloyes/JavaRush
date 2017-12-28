package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        map.put("name","Ivanov");
//        map.put("country", "Ukraine");
//        map.put("city", "Kiev");
//        map.put("age", null);
//        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry m: params.entrySet()){
            if (m.getValue() != null)
            stringBuilder
                    .append(m.getKey())
                    .append(" = ")
                    .append("'")
                    .append(m.getValue())
                    .append("'")
                    .append(" and ");
        }
        if (stringBuilder.toString().lastIndexOf(" and") == stringBuilder.length() - 5)
            stringBuilder.delete(stringBuilder.length() - 5, stringBuilder.length());
        return stringBuilder.toString();
    }
}
