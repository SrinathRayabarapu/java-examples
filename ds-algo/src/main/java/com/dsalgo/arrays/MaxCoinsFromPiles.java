package com.dsalgo.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-number-of-coins-you-can-get/description/
 */
public class MaxCoinsFromPiles {

    public static void main(String[] args) {
        int[] input = {2,4,1,2,7,8};
        System.out.println(maxCoins(input));

        int[] input1 = {9,8,7,6,5,1,2,3,4};
        System.out.println(maxCoins(input1));
    }

    public static int maxCoins(int[] piles) {

        Arrays.sort(piles);

        int startIndex = 0;
        int endIndex = 2;

        int maxCoins = 0;

        while(startIndex < (piles.length - endIndex)){
            maxCoins += piles[piles.length - endIndex];
            endIndex += 2;
            startIndex++;
        }

        return maxCoins;
    }

}