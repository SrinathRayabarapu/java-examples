package com.dsalgo.arrays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MergeTimeIntervalsMainTest {

    @Test
    void mergeAllMatchingIntervals() {

    }

    @Test
    void mergeNoMatchingIntervals() {

    }

    @Test
    void mergePartialMatchingIntervals() {
        int[][] timeIntervals = {{1, 4}, {2, 5}, {7, 10}, {12, 16}};
        // output: [1, 5], [7, 10], [12, 16]

        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        expected.add(list);
        list = new ArrayList<>();
        list.add(7);
        list.add(10);
        expected.add(list);
        list = new ArrayList<>();
        list.add(12);
        list.add(16);
        expected.add(list);

        List<List<Integer>> lists = new MergeTimeIntervalsMain().mergeIntervals(timeIntervals);
//        assertEquals(expected, lists);
    }

}