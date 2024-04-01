package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * given an array, return starting index of subarray of lenth k where subarray has the least average
 */
@Slf4j
public class SubArrayOfLeastAverage {

    public static void main(String[] args) {
        int[] array = {3, 7, 5, 20, -10, 0, 12};
        int k = 2;
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

        int sum = 0;
        // find subArraySize array sum
        sum = Arrays.stream(array).limit(subArraySize).sum();

        System.out.println("sum = " + sum);
        int min_sum = sum;
        int returnIndex = 0;

        for (int i = subArraySize; i < array.length; i++) {
            sum = sum - array[i-subArraySize] + array[i];
            if(sum < min_sum){
                returnIndex = i-subArraySize+1;
                min_sum = sum;
            }
        }

        return returnIndex;
    }

}
