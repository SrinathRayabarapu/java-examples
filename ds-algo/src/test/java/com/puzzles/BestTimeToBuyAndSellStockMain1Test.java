package com.puzzles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyAndSellStockMain1Test {

    @Test
    void getMaxProfit() {

        int[] input = new int[] {7,1,5,3,6,4};
        assertEquals(7, BestTimeToBuyAndSellStockMain1.getMaxProfit(input));

        input = new int[] {1,2,3,4,5};
        assertEquals(4, BestTimeToBuyAndSellStockMain1.getMaxProfit(input));

        input = new int[] {7,6,4,3,1};
        assertEquals(0, BestTimeToBuyAndSellStockMain1.getMaxProfit(input));
    }

}