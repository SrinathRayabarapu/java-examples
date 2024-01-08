package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * given an array, return starting index of subarray of lenth k where subarray has the least average
 */
@Slf4j
public class SubArrayOfLeastAverage {

    public static void main(String[] args) {
        int[] array = {3, 7, 90, 20, 10, 50, 40};
        int k = 3;
        int index = new SubArrayOfLeastAverage().findIndexOfLeastAverageSubArray(array, k);
        log.info("Index: {}", index);
    }

    /**
     * TC : O(n)
     * SC : O(n)
     *
     * @param array
     * @param subArraySize
     * @return
     */
    public int findIndexOfLeastAverageSubArray(int[] array, int subArraySize) {

        int[] prefixArray = new int[array.length];

        prefixArray[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            prefixArray[i] = array[i] + prefixArray[i-1];
        }
        log.info(Arrays.toString(prefixArray));


        int startIndex = 0;
        int endIndex = startIndex + subArraySize-1;

        int leastAverage = Integer.MAX_VALUE;
        int returnIndex = 0;

        while (endIndex < array.length) {
            int average = 0;
            if(startIndex == 0){
                average = prefixArray[endIndex] / subArraySize;
            } else {
                average = (prefixArray[endIndex] - prefixArray[startIndex-1]) / subArraySize;
            }

            if(average <= leastAverage){
                leastAverage = average;
                returnIndex = startIndex;
            }

            startIndex++;
            endIndex++;
        }

        return returnIndex;
    }

}
