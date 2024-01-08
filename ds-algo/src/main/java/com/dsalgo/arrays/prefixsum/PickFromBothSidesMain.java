package com.dsalgo.arrays.prefixsum;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 *
 */
@Slf4j
public class PickFromBothSidesMain {

    public static void main(String[] args) {

        int[] array = {1, 2};
        int numberOfElements = 1;

        log.info("Given array : {}", Arrays.toString(array));

        // O(n)
        createPrefixSumArray(array);

        log.info("PFS array : {}", Arrays.toString(array));

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= numberOfElements; i++) {
            if (i == 0) {
                maxSum = Math.max(maxSum, array[array.length-1] - array[array.length-1 - numberOfElements]);
            } else if (i == numberOfElements) {
                maxSum = Math.max(maxSum, array[numberOfElements - 1]);
            } else {
                maxSum = Math.max(maxSum, array[i-1] + (array[array.length-1] - (array[(array.length-1) - (numberOfElements-i)])));
            }
        }

        log.info("Max Sum : {}", maxSum);

    }

    private static void createPrefixSumArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1];
        }
    }

}
