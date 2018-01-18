package com.javarush.task.task25.task2503;


import java.util.Arrays;

/*
Свой enum
*/
public class Solution {
    /**
     * Output:
     * <p/>
     * Available Amount
     * Account Number
     * Bank Name
     * --------------------
     * Available Amount
     * Bank Name
     */

//    Customer("Customer"),
//    BankName("Bank Name"),
//    AccountNumber("Account Number"),
//    Amount("Available Amount")

    public static void main(String[] args) {

        Column.configureColumns(Column.Amount, Column.AccountNumber, Column.BankName);
        //System.out.println(Arrays.toString(Column.realOrder));
        for (Columnable columnable : Column.getVisibleColumns()) {
            System.out.println(columnable.getColumnName());
        }

        System.out.println("--------------------");
//        System.out.println(Column.BankName.ordinal());
//        System.out.println(Arrays.toString(Column.realOrder));
        Column.BankName.hide();

        for (Columnable columnable : Column.getVisibleColumns()) {
            System.out.println(columnable.getColumnName());
        }
    }
}
