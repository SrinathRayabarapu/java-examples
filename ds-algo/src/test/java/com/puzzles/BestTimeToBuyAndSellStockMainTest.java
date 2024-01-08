package com.puzzles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyAndSellStockMainTest {

    @Test
    void getMaximumProfit() {
        int[] input = new int[]{7,1,5,3,6,4};
        assertEquals(5, BestTimeToBuyAndSellStockMain.getMaximumProfit(input));

        input = new int[]{7,6,4,3,1};
        assertEquals(0, BestTimeToBuyAndSellStockMain.getMaximumProfit(input));

        input = new int[]{7,1,5,3,6,4};
        assertEquals(5, BestTimeToBuyAndSellStockMain.getMaximumProfitGood(input));

        input = new int[]{7,6,4,3,1};
        assertEquals(0, BestTimeToBuyAndSellStockMain.getMaximumProfitGood(input));
    }

}
