package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * given a sum and coins array, find maximum number of combinations - DynamicProblem
 * <p>
 *
 * Other approaches:
 * https://algorithms.tutorialhorizon.com/dynamic-programming-coin-change-problem/
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class CoinChangeDPMain {

    public static void main(String[] args) {
        int combinations = coinChange(6, new int[]{1, 2, 5});
        log.info("Combinations : " + combinations);
    }

    private static int coinChange(int sum, int[] coins) {
        int[] combinations = new int[sum + 1];

        combinations[0] = 1;

        for (int coin : coins) {
            for (int i = 0; i < combinations.length; i++) {
                if (coin <= i) {
                    combinations[i] = combinations[i] + combinations[i - coin];
                    log.info(coin + ", " + i + ", " + Arrays.toString(combinations));
                }
            }
        }
        return combinations[sum];
    }

}