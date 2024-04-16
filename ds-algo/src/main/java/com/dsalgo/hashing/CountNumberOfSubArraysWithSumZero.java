package com.dsalgo.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * given an array, count the number of subarrays with sum 0
 */
public class CountNumberOfSubArraysWithSumZero {

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, -1, 3, 2, -5};

        int count = findSubArraysCount(arr);
        System.out.println("count = " + count);
    }

    private static int findSubArraysCount(int[] arr) {

        int[] preArr = new int[arr.length];
        preArr[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            preArr[i] = preArr[i-1] + arr[i];
        }

        int counter = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < preArr.length; i++) {
            if(preArr[i] == 0){
                counter++;
            }
            if(map.get(preArr[i]) != null){
                counter++;
            } else {
                map.put(preArr[i], preArr[i]);
            }
        }

        return counter;
    }

}