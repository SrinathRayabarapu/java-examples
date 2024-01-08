package com.puzzles;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any
 * time. However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 */
public class BestTimeToBuyAndSellStockMain1 {

    /**
     * carry forward approach :
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param stockPrices
     * @return
     */
    public static int getMaxProfit(int[] stockPrices){
        int profitFromPriceGain = 0;

        for (int i = 0; i < stockPrices.length-1; i++) {
            if(stockPrices[i] < stockPrices[i+1]) {
                profitFromPriceGain += stockPrices[i+1] - stockPrices[i];
            }
        }

        return profitFromPriceGain;
    }

}
