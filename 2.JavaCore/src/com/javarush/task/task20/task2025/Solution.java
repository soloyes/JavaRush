package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        List<Long> longs = new ArrayList<>();
        long before = Calendar.getInstance().getTimeInMillis();
        ///
        for (int i = 0; i < 10*Integer.MAX_VALUE; i++) {

        }
        ///
        long after = Calendar.getInstance().getTimeInMillis();
        System.out.println("time = " + ((after-before)) + "ms");
        return result;
    }

    private static long fastPow(Long val, int pow){
        if (pow == 0) return 1;
        if (pow % 2 == 1) return fastPow(val, pow - 1) * val;
        else {
            long tmp = fastPow(val, pow / 2);
            return tmp * tmp;
        }
    }

    public static void main(String[] args) {
        Solution.getNumbers(Integer.MAX_VALUE);
        //Solution.getNumbers(50);
    }
}
