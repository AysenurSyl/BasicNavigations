package com.cbt.utilities;

public class StringUtility {

    public static void verifyEquals(String actual, String expected){
        if (actual.equals(expected)){
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
            System.out.println("Expected result is: " + expected);
            System.out.println("Actual result is: " + actual);
        }
    }
}
