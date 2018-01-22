package com.javarush.task.task26.task2601;

import java.util.*;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
//        Integer[] a = new Integer[]{13, 8, 15, 5, 17, 20, 16};
//        sort(a);
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        double med;
        if (array.length % 2 != 0) med = array[array.length/2];
        else med = (double) (array[array.length/2 - 1] + array[array.length/2])/2;

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double dstO1 = Math.abs(med - o1);
                double dstO2 = Math.abs(med - o2);
                return (int) (dstO1 - dstO2);
            }
        });
//        System.out.println(med);
//        System.out.println(Arrays.deepToString(array));
        return array;
    }
}
