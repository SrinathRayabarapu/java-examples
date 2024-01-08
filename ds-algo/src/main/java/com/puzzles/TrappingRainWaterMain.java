package com.puzzles;

import lombok.extern.slf4j.Slf4j;

/**
 * coming up with math formula is imp
 * <p>
 * https://leetcode.com/problems/trapping-rain-water/
 */
@Slf4j
public class TrappingRainWaterMain {

    public static void main(String[] args) {
        int[] inputBlocks = new int[]{0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2};

        int area = findWaterTrappedAreaOk(inputBlocks);
        log.info("area OK 1: {}", area);

        inputBlocks = new int[]{2, 0, 3, 1, 0, 4};

        area = findWaterTrappedAreaOk(inputBlocks);
        log.info("area OK 2: {}", area);


        log.info("----------------------------");


        inputBlocks = new int[]{0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2};

        area = findWaterTrappedAreaGood(inputBlocks);
        log.info("area GOOD 1: {}", area);

        inputBlocks = new int[]{2, 0, 3, 1, 0, 4};

        area = findWaterTrappedAreaGood(inputBlocks);
        log.info("area GOOD 2: {}", area);
    }

    /**
     * @param inputBlocks
     * @return
     */
    private static int findWaterTrappedAreaGood(int[] inputBlocks) {

        int leftP = 0;
        int rightP = inputBlocks.length - 1;

        int maxLeft = 0;
        int maxRight = 0;

        int totalWater = 0;

        while (leftP < rightP) {
            if (inputBlocks[leftP] < inputBlocks[rightP]) {
                if (inputBlocks[leftP] >= maxLeft) {
                    maxLeft = inputBlocks[leftP];
                } else {
                    totalWater += maxLeft - inputBlocks[leftP];
                }
                leftP++;
            } else {
                if (inputBlocks[rightP] >= maxRight) {
                    maxRight = inputBlocks[rightP];
                } else {
                    totalWater += maxRight - inputBlocks[rightP];
                }
                rightP--;
            }
        }

        return totalWater;
    }

    /**
     * min(maxLeft of i, maxRight of i) - inputBlocks[i]
     * <p>
     * O(n^2)
     *
     * @param inputBlocks
     * @return
     */
    private static int findWaterTrappedAreaOk(int[] inputBlocks) {

        int totalWater = 0;

        for (int i = 0; i < inputBlocks.length; i++) {

            int maxLeft = 0;
            int maxRight = 0;
            int leftP = i;
            int rightP = i;

            while (leftP >= 0) {
                maxLeft = Math.max(inputBlocks[leftP], maxLeft);
                leftP--;
            }

            while (rightP < inputBlocks.length) {
                maxRight = Math.max(inputBlocks[rightP], maxRight);
                rightP++;
            }

            int area = Math.min(maxLeft, maxRight) - inputBlocks[i];

            totalWater += area;
        }

        return totalWater;
    }

}
