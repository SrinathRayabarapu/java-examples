package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * handles below cases:
 *
 * 1. given an unsorted array, find pairs which sum equals to a given number
 * 2. given a sorted array, find pairs which sum equals to a given number
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class FindPairsOfGivenSumMain {

    public static void main(String[] args) {

        // case 1 - given unsorted array
        int[] intArray1 = {11, 2, 4, 1, 8, 4, 10, 15, 18, 9, 5};
        int sum = 20;
        log.info("Finding pairs in unsorted array for sum : {}", sum);
        findPairsInUnsortedArray(intArray1, sum);

        // case 2 - given sorted array
        int[] intArray2 = {0, 2, 4, 6, 12, 14, 16, 20, 22, 26};
        sum = 26;
        log.info("Finding pairs in sorted array for sum : {}", sum);
        findPairsInSortedArray(intArray2, sum);

    }

    /**
     * two pointer logic
     *
     * TC: O(n)
     * SC: O(1)
     */
    private static void findPairsInSortedArray(int[] inputArray, int sum) {
        int l = 0;
        int r = inputArray.length-1;

        while (l < r){
            if(inputArray[l] + inputArray[r] == sum){
                log.info("Pair : " + inputArray[l] +", " + inputArray[r]);
                l++;
                r--;
            } else if(inputArray[l] + inputArray[r] > sum){
                r--;
            } else {
                l++;
            }
        }
    }

    /**
     * using hashset is the key
     *
     * TC: O(n)
     * SCL O(n)
     */
    private static void findPairsInUnsortedArray(int[] intArray, int sum) {

        Set<Integer> intSet = new HashSet<>();
        for (int j : intArray) {
            if (intSet.contains(sum - j)) {
                log.info("Pair : " + (sum - j) + "," + j);
            }
            intSet.add(j);
        }
    }

}