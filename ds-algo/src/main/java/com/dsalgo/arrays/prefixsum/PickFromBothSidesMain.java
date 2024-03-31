package com.dsalgo.arrays.prefixsum;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class PickFromBothSidesMain {

    public static void main(String[] args) {

        int[] array = {5, -2, 3 , 1, 2};
        int numberOfElements = 5;

//        approach1(array, numberOfElements);

        approach2(array, numberOfElements);

//        System.out.println(Integer.MIN_VALUE);

    }

    private static void approach2(int[] array, int numberOfElements) {

        System.out.println("Original Array : " + Arrays.toString(array));

        int[] prefixArray = Arrays.copyOf(array, array.length);
        createPrefixSumArray(prefixArray);
        System.out.println("Prefix array : " + Arrays.toString(prefixArray));

        int[] suffixArray = Arrays.copyOf(array, array.length);
        createSuffixSumArray(suffixArray);
        System.out.println("Suffix array : " + Arrays.toString(suffixArray));

        int max = Math.max(prefixArray[numberOfElements-1], suffixArray[suffixArray.length-numberOfElements]);

        for (int i = 1; i < numberOfElements; i++) {
            max = Math.max(max, prefixArray[i-1] + suffixArray[suffixArray.length - (numberOfElements-i)]);
        }

        System.out.println(max);

    }

    private static void createSuffixSumArray(int[] suffixArray) {
        for (int i = suffixArray.length-2; -1 < i; i--) {
            suffixArray[i] += suffixArray[i+1];
        }
    }

    private static void approach1(int[] array, int numberOfElements) {
        log.info("Given array : {}", Arrays.toString(array));

        // O(n)
        createPrefixSumArray(array);

        log.info("PFS array : {}", Arrays.toString(array));

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= numberOfElements; i++) {
            if (i == numberOfElements) {
                maxSum = Math.max(maxSum, array[numberOfElements - 1]);
            } else if (i == 0) {
                maxSum = Math.max(maxSum, array[array.length-1] - array[array.length-1 - numberOfElements]);
            } else {
                maxSum = Math.max(maxSum, array[i-1] + (array[array.length-1] - (array[(array.length-1) - (numberOfElements -i)])));
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
