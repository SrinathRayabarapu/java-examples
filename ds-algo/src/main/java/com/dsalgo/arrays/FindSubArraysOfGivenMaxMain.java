package com.dsalgo.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * given a unsorted array, find all sub arrays whose sum is given sum
 *
 * @author Srinath.Rayabarapu
 */
public class FindSubArraysOfGivenMaxMain {

    public static void main(String[] args) {

        int[] arr = {10, 1, -1, 2, -2, -20, -20, 10, 10};
        int sum = -10;

        findAllSubArraysUsingMap(arr, sum);
    }

    private static void findAllSubArraysUsingMap(int[] arr, int sum) {

        int cur_sum = 0;
        int startInd = 0;
        int endInd = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            cur_sum += arr[i];

            // if current sum is equal to sum at this stage, subarray is starting from 0 to i index
            if ((cur_sum - sum) == 0) {
                startInd = 0;
                endInd = i;
                System.out.printf("Found between indexes %d and %d%n", startInd, endInd);
//                break;
            }

            // if map already has value, means we already have subarray with sum
            if (map.containsKey(cur_sum - sum)) {
                startInd = map.get(cur_sum - sum) + 1; // +1 is because last i index value is not matched
                endInd = i;
                System.out.printf("Found between indexes %d and %d%n", startInd, endInd);
//                break;
            }
            // if not found, insert it in map
            map.put(cur_sum, i);

        }

        /*if(endInd == -1){
            System.out.printf("No sub arrays found!");
        } else {
            System.out.printf("Found between indexes %d and %d", startInd, endInd);
        }*/
    }

}
