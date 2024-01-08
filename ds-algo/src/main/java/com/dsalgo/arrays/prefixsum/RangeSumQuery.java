package com.dsalgo.arrays.prefixsum;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 *
 */
@Slf4j
public class RangeSumQuery {

    public long[] rangeSum(int[] array, int[][] rangeArray) {

        log.info("Given array : {}", Arrays.toString(array));

        // O(n)
        long[] prefixSumArray = createPrefixSumArray(array);

        log.info("PFS array : {}", Arrays.toString(prefixSumArray));

        long[] out = new long[rangeArray.length];

        int k=0;
        for (int[] ints : rangeArray) {
            if (ints[0] - 1 == 0) {
                out[k++] = prefixSumArray[ints[1] - 1];
            } else {
                out[k++] = prefixSumArray[ints[1] - 1] - prefixSumArray[ints[0] - 2];
            }
        }

        return out;
    }

    private long[] createPrefixSumArray(int[] array) {
        long[] longArray = new long[array.length];
        longArray[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            longArray[i] = longArray[i - 1] + array[i];
        }
        return longArray;
    }

}