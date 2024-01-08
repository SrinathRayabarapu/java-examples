package com.dsalgo.arrays.prefixsum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class RangeSumQueryTest {

    @Test
    void rangeSumTest1() {

        int[] array = {1, 2, 3, 4, 5};
        int[][] rangeArray = { {1, 4}, {2, 3} };

        RangeSumQuery rangeSumQuery = new RangeSumQuery();

        long[] actuals = rangeSumQuery.rangeSum(array, rangeArray);
        long[] expected = {10, 5};

        assertArrayEquals(expected, actuals);
    }

    @Test
    void rangeSumTest2() {
        int[] array = {2, 2, 2};
        int[][] rangeArray = { {1, 1}, {2, 3} };

        RangeSumQuery rangeSumQuery = new RangeSumQuery();

        long[] actuals = rangeSumQuery.rangeSum(array, rangeArray);
        long[] expected = {2, 4};

        assertArrayEquals(expected, actuals);
    }

}