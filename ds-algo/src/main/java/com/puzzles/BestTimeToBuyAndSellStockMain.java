package com.puzzles;

/**
 *  You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *  You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the
 *  future to sell that stock.
 *
 *  Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 */
public class BestTimeToBuyAndSellStockMain {

    /**
     * TC: O(n^2) - not good
     * SC: O(1)
     *
     * @param stocksPrices
     * @return
     */
    public static int getMaximumProfit(int[] stocksPrices) {

        int maxProfit = 0;
        for (int i = 0; i < stocksPrices.length; i++) {
            for (int j = i; j < stocksPrices.length; j++) {
                maxProfit = Math.max(maxProfit, stocksPrices[j] - stocksPrices[i]);
            }
        }

        return maxProfit;
    }

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param stocksPrices
     * @return
     */
    public static int getMaximumProfitGood(int[] stocksPrices) {

        int leastSeenSoFar = Integer.MAX_VALUE;
        int overAllProfit = 0;
        int profitIfSoldToday = 0;

        for (int stocksPrice : stocksPrices) {
            if (stocksPrice < leastSeenSoFar) {
                leastSeenSoFar = stocksPrice;
            }
            profitIfSoldToday = stocksPrice - leastSeenSoFar;
            if (overAllProfit < profitIfSoldToday) {
                overAllProfit = profitIfSoldToday;
            }
        }

        return overAllProfit;
    }

}
