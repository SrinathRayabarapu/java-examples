package com.dsalgo.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * alternative this problem also is :
 * given an array of 1's and 0's, find the length of longest subarray which has equal 1's and 0's
 *
 */
public class FindLongestSubArrayWithSumMain {

    public static void main(String[] args) {
        int[] arr = {3, 3, 4, -5, -2, 2, 1, -3, 3};

        int length = findLongestSubArrayWithSumZero(arr);
        System.out.println("Max length = " + length);
    }

    private static int findLongestSubArrayWithSumZero(int[] arr) {
        // 1. calculate the prefix array
        // 2. store the element with it's index. If you see an element already exists then, find the max
        // distance between the current element add index of element in map

        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        System.out.println("prefix = " + Arrays.toString(prefix));

        Map<Integer, Integer> map = new HashMap<>();
        int maxDistance = Integer.MIN_VALUE;

        for (int i = 0; i < prefix.length; i++) {
            if(map.get(prefix[i]) != null){
                maxDistance = Math.max(maxDistance, i - map.get(prefix[i]));
            }
            map.put(prefix[i], 1);
        }

        return maxDistance;
    }

}