package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Given an array of n integers find an equilibrium number.
 * The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of
 * elements at higher indexes.
 * If equilibrium number does not exist print -1
 * <p>
 * https://leetcode.com/problems/find-pivot-index/
 */
@Slf4j
public class EquilibriumIndexMain {

    public static void main(String[] args) {

        int[] inputArray = {1, 7, 3, 6, 5, 6};

        int index = findEquilibriumIndex(inputArray);

        log.info("Equilibrium Index is : {} and Number is : {}", index, inputArray[index]);
    }

    /**
     * TC: O(n)
     * SC: O(1)
     * <p>
     * idea: Keep a total sum. Start comparing all i'th leftSum to total sum - left sum - i'th position. if equals then
     * i'th position is equilibrium
     * <p>
     * Works for both +ve and -ve numbers
     *
     * @param inputArray
     * @return
     */
    private static int findEquilibriumIndex(int[] inputArray) {

        int sum = Arrays.stream(inputArray).sum();

        int leftSum = 0;

        for (int i = 0; i < inputArray.length; i++) {
            if (leftSum == (sum-leftSum)-inputArray[i]) {
                return i;
            }
            leftSum += inputArray[i];
        }

        return -1;
    }

}