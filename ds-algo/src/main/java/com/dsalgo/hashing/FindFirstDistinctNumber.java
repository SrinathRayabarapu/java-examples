package com.dsalgo.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * TC: O(n)
 * SC: O(n)
 */
public class FindFirstDistinctNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 5, 1, 2, 8};

        int distinctNumber = findFirstDistinctNumber(arr);

        System.out.println("distinctNumber = " + distinctNumber);
    }

    private static int findFirstDistinctNumber(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr){
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (int i : arr){
            if(map.get(i) == 1){
                return i;
            }
        }

        return -1;
    }

}
