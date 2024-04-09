package com.dsalgo.scaler.sorting.day20;

import java.util.Arrays;

/**
 * Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p
 * in the array equals p.
 */
public class NobleInteger {

    public static void main(String[] args) {
        int[] intArray = {3, 2, 1, 3};

        isNumberExists(intArray);
    }

    private static void isNumberExists(int[] intArray) {
        Arrays.sort(intArray);
        for (int i = 0; i < intArray.length; i++) {
            if((i+1 < intArray.length-1)
                    && (intArray[i] < intArray[i+1])
                    && (intArray[i] == intArray.length-1-i)){
                System.out.println("such number exists : " + intArray[i]);
                break;
            }
        }
        System.out.println("Answer is above !");
    }

}
