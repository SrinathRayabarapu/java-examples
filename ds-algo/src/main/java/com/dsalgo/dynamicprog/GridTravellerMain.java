package com.dsalgo.dynamicprog;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Say that you are a traveler on a 2D grid. You begin in the top-left corner and your goal is to
 * travel to the bottom-right corner. You may only move down or right.
 *
 * In how many ways can you travel to the goal on a grid with dimensions m * n?
 *
 * Ref: https://youtu.be/oBt53YbR9Kk?t=2347
 */
public class GridTravellerMain {

    public static void main(String[] args) {

        // m*n input matrix
        int m = 5, n =5;

        Map<String, BigInteger> cache = new HashMap<>();

        System.out.println("...");
        System.out.println("Number of ways in simple prog : " + gridTravelSimple(m, n));
        System.out.println("Number of ways in memoization prog : " + gridTravelMemoization(m, n, cache));

    }

    /**
     * TC: O(2^m+n)
     * SC: O(m+n)
     *
     * @param m
     * @param n
     * @return
     */
    private static BigInteger gridTravelSimple(int m, int n) {

        if(m == 0 || n == 0) return BigInteger.ZERO;
        if(m == 1 || n == 1) return BigInteger.ONE;

        System.out.println("m = " + m + ", n = " + n);

        // travelling to down or right
        return gridTravelSimple(m-1, n).add(gridTravelSimple(m, n-1));
    }

    /**
     * TC: O(m*n)
     * SC: O(m+n)
     *
     * @param m
     * @param n
     * @param cache
     * @return
     */
    private static BigInteger gridTravelMemoization(int m, int n, Map<String, BigInteger> cache) {

        if(cache.get(m+","+n) != null) {
            return cache.get(m+","+n);
        }

        if(m == 0 || n == 0) return BigInteger.ZERO;
        if(m == 1 || n == 1) return BigInteger.ONE;

        // traveling to down or right but with a cache
        cache.put(m+","+n, gridTravelMemoization(m-1, n, cache).add(gridTravelMemoization(m, n-1, cache)));

        return cache.get(m+","+n);
    }

}