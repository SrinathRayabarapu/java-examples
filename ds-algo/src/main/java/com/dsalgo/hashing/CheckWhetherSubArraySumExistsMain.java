package com.dsalgo.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * given an array, check whether exists a subarray whose sum is 0
 *
 * TC: O(n)
 * SC: O(n)
 */
public class CheckWhetherSubArraySumExistsMain {

    public static void main(String[] args) {
        int[] array = {2, 2, 1, -3, 4, 3, 1, -2, -3, 2};
        boolean exists = checkSubArraySumExists(array);
        System.out.println("exists = " + exists);
    }

    private static boolean checkSubArraySumExists(int[] array) {
        // 1. construct prefix array
        // 2. check if prefix array has 0, then return true
        // 3. check if prefix has distinct elements and their count is < length of the array then return true

        int[] pArr = new int[array.length];
        pArr[0] = array[0];

        if(pArr[0] == 0){
            return true;
        }

        Set<Integer> set = new HashSet<>();
        set.add(pArr[0]);

        for (int j = 1; j < array.length; j++) {
            pArr[j] = pArr[j-1] + array[j];
            if(pArr[j] == 0){
                return true;
            }
            set.add(pArr[j]);
        }

        return set.size() < pArr.length;
    }

}