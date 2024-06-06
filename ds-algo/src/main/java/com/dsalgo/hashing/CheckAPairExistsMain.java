package com.dsalgo.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * given an array, check whether a pair (i, j) exists such that i != j and arr[i] + arr[j] = k
 */
public class CheckAPairExistsMain {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, -2, 4, 5, 11};
        int k = 20;

        boolean exists = checkPairExists1(arr, k);
        System.out.println("exists = " + exists);
    }

    /**
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @param k
     * @return
     */
    private static boolean checkPairExists(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if(map.get(k-arr[i]) != null && map.get(k-arr[i]) < i){
                return true;
            } else {
                map.put(arr[i], i);
            }
        }

        return false;
    }

    private static boolean checkPairExists1(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();

        for (int j : arr) {
            if (set.contains(k - j)) {
                return true;
            } else {
                set.add(j);
            }
        }

        return false;
    }
}