package com.puzzles;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * https://leetcode.com/problems/container-with-most-water/
 */
@Slf4j
public class ContainerWithMostWaterMain {

    public static void main(String[] args) {

        int[] inputArray = new int[]{7, 1, 2, 3, 9};

        int maxWaterStorageCapacity = findContainerWithMostWaterOk(inputArray);
        log.info("findContainerWithMostWaterOk : {}", maxWaterStorageCapacity);

        inputArray = new int[]{4, 8, 1, 2, 3, 9};
        maxWaterStorageCapacity = findContainerWithMostWaterGood(inputArray);
        log.info("findContainerWithMostWaterGood : {}", maxWaterStorageCapacity);
    }


    /**
     * O(n) - two pointer technique
     *
     * @param inputArray
     * @return
     */
    private static int findContainerWithMostWaterGood(int[] inputArray) {
        int start = 0;
        int end = inputArray.length-1;
        int maxArea = 0;

        while (start < end){
            int area = Math.min(inputArray[start], inputArray[end]) * (end - start);
            maxArea = Math.max(maxArea, area);
            if(inputArray[start] < inputArray[end]){
                start++;
            } else {
                end--;
            }
        }

        return maxArea;
    }

    /**
     * O(n^2)
     *
     * @param inputArray
     * @return
     */
    private static int findContainerWithMostWaterOk(int[] inputArray) {

        int maxCapacity = 0;

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i+1; j < inputArray.length; j++) {
                // area = length * width
                int capacity = Math.min(inputArray[i], inputArray[j]) * (j-i);
                maxCapacity = Math.max(maxCapacity, capacity);
            }
        }
        return maxCapacity;
    }

}