package com.puzzles;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the
 * future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BestTimeToBuyAndSellStockMain {

    public static void main(String[] args) {
        int[] input = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(getMaximumProfitGood(input));
    }

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param prices
     * @return
     */
    public static int getMaximumProfitGood(int[] prices) {
        int maxProfit = 0;
        int min = prices[0];

        for (int price : prices) {
            int curProfit = price - min;
            maxProfit = Math.max(curProfit, maxProfit);
            min = Math.min(min, price);
        }

        return maxProfit;
    }

}
