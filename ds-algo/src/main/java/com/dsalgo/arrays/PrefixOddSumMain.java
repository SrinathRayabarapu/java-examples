package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class PrefixOddSumMain {

    public static void main(String[] args) {

        int[] inputArray = {-3, 6, 2, 4, 5, 2, 8, -9, 3, 1};

        log.info("Given array : {}", Arrays.toString(inputArray));

        inputArray = buildPrefixOddSumArray(inputArray);

        log.info("Prefix Odd sum array : {}", Arrays.toString(inputArray));
    }

    /**
     * TC: O(n)
     * SC: O(1) since we are using the same given input
     * @param inputArray
     * @return
     */
    public static int[] buildPrefixOddSumArray(int[] inputArray) {

        int oddSum = 0;

        for (int i = 0; i < inputArray.length; i++) {
            if (i % 2 != 0) {
                oddSum += inputArray[i];
            }
            inputArray[i] = oddSum;
        }

        return inputArray;
    }

}
