package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * given array, build and print its prefix sum
 */
@Slf4j
public class PrefixSumMain {

    public static void main(String[] args) {

        int[] inputArray = {-3, 6, 2, 4, 5, 2, 8, -9, 3, 1};

        log.info("Given array : {}", Arrays.toString(inputArray));

        buildPrefixSumArray(inputArray);

        log.info("Prefix sum array : {}", Arrays.toString(inputArray));
    }

    /**
     * TC: O(n)
     * SC: O(1) since we are using the same given input
     * @param inputArray
     * @return
     */
    private static int[] buildPrefixSumArray(int[] inputArray) {

        for (int i = 0; i < inputArray.length; i++) {
            if(i != 0){
                inputArray[i] = inputArray[i-1] + inputArray[i];
            }
        }
        return inputArray;
    }

}