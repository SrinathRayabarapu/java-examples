package com.aaa;

import java.util.Arrays;


public class MaxProfit {
	
	
	public static void main(String[] args) {
		//System.out.println(10%8);
		//int[] lengths = {26, 103, 59};
		//System.out.println(maxProfit(100, 10, lengths));
		
		
		// 3, 5, [200, 400, 700]
		//1300 / 5
		System.out.println(10^2);
		
	}

	/*
	 * 100, 10, {26, 103, 59}
	 */
    static int maxProfit(int cost_per_cut, int metal_price, int[] lengths) {
    	
    	Arrays.sort(lengths);
    	
    	int maxProfit = 0;
    	
    	for(int i=lengths.length; 0 < i; i--){
    		
    		int j = lengths[i-1];
    		int cuts = 0;
    		for(int length : lengths){
    			if(length % j == 0){
    				cuts = cuts + (length/j);
    			}
    		}
    		
    		int profit = (cuts * metal_price * j);
    		int cost = cuts * cost_per_cut;
    		
    		int netProft = profit - cost;
    		
    		if(maxProfit < netProft){
    			maxProfit = netProft;
    		}
    	}
    	
    	return maxProfit;
    }
}