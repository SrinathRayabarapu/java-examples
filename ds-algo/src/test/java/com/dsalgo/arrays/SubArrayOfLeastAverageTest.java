package com.dsalgo.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubArrayOfLeastAverageTest {

    @Test
    void findIndexOfLeastAverageSubArray() {
        int[] array = {3, 7, 90, 20, 10, 50, 40};
        SubArrayOfLeastAverage subArrayOfLeastAverage = new SubArrayOfLeastAverage();
        assertEquals(3, subArrayOfLeastAverage.findIndexOfLeastAverageSubArray(array, 3));
    }

    @Test
    void findIndexOfLeastAverageSubArray1() {
        int[] array = {3, 7, 5, 20, -10, 0, 12};
        SubArrayOfLeastAverage subArrayOfLeastAverage = new SubArrayOfLeastAverage();
        assertEquals(4, subArrayOfLeastAverage.findIndexOfLeastAverageSubArray(array, 2));
    }

    @Test
    void findIndexOfLeastAverageSubArray2() {
        int[] array = {20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11};
        SubArrayOfLeastAverage subArrayOfLeastAverage = new SubArrayOfLeastAverage();
        assertEquals(3, subArrayOfLeastAverage.findIndexOfLeastAverageSubArray(array, 9));
    }

    @Test
    void findIndexOfLeastAverageSubArray3() {
        int[] array = {345,119,425,67,465,376,179,472,210,404,451,389,487,417,50,467,235,465,496,35,386,172,88,98,391,315,68,346,260,309,275,20,87,336,239,467,338,118,467,448,30,406,382,191,347,182,92,185,351,190,312,384,137,479,289,334,400,152,400,453,187,264,103,497,367,33,264,179,258,345,42,121,273,389,214,466,401,432,225,407,395,276,244,111,149,26,320,446,86,474,393,420,106,209,391,153,113};
        SubArrayOfLeastAverage subArrayOfLeastAverage = new SubArrayOfLeastAverage();
//        assertEquals(14, subArrayOfLeastAverage.findIndexOfLeastAverageSubArray(array, 72));
    }



}