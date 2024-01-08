package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

import static com.dsalgo.arrays.PrefixEvenSumMain.buildPrefixEvenSumArray;
import static com.dsalgo.arrays.PrefixOddSumMain.buildPrefixOddSumArray;

/**
 * Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from
 * these indices makes the sum of even-indexed and odd-indexed array elements equal.
 */
@Slf4j
public class SpecialIndicesCountMain {

    public static void main(String[] args) {

//        int[] inputArray = {2, 1, 6, 4}; // answer : 1
        int[] inputArray = {1, 1, 1}; // answer : 3

        int count = countOfSpecialIndices(inputArray);

        log.info("Special Indices count is : {}", count);
    }

    /**
     * build even pre sum array
     * build odd pre sum array
     *
     * @param inputArray
     * @return
     */
    private static int countOfSpecialIndices(int[] inputArray) {

        int[] psEven = new int[inputArray.length];
        System.arraycopy(inputArray, 0, psEven, 0, psEven.length);

        buildPrefixEvenSumArray(psEven);

        int[] psOdd = new int[inputArray.length];
        System.arraycopy(inputArray, 0, psOdd, 0, psOdd.length);

        buildPrefixOddSumArray(psOdd);

        int count = 0;

        for (int i = 0; i < inputArray.length; i++) {
            int psEvenSum;
            int psOddSum;

            if (i != 0) {
                psEvenSum = psEven[i - 1] + psOdd[inputArray.length - 1] - psOdd[i];
                psOddSum = psOdd[i - 1] + psEven[inputArray.length - 1] - psEven[i];
            } else {
                psEvenSum = psOdd[inputArray.length - 1] - psOdd[i];
                psOddSum = psEven[inputArray.length - 1] - psEven[i];
            }

            if (psEvenSum == psOddSum) {
                count++;
            }
        }

        return count;
    }

}
