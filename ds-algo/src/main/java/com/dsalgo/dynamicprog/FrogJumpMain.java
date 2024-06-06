package com.dsalgo.dynamicprog;

/**
 * There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair.
 * 'HEIGHT[i]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in
 * the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). If the Frog is on 'ith' staircase,
 * he can jump either to '(i+1)th' stair or to '(i+2)th' stair. Your task is to find the minimum total energy
 * used by the frog to reach from '1st' stair to 'Nth' stair.
 *
 * For Example:
 * If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 1st stair to 2nd stair
 * (|20-10| = 10 energy lost) and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost). So, the
 * total energy lost is 20.
 */
public class FrogJumpMain {

    public static void main(String[] args) {
        int[] arr = {10,20,30,10};

        int[] dp = new int[arr.length];
        int index = arr.length-1;
        int minCost = findMinCostMemoization(arr, index, dp);
        System.out.println("minCost = " + minCost);

        minCost = findMinSpaceOptimised(arr);
        System.out.println("minCost = " + minCost);
    }

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int findMinSpaceOptimised(int[] arr) {
        int prev1 = 0;
        int prev2 = 0;

        for (int i = 1; i < arr.length; i++) {
            int fJump = prev1 + Math.abs(arr[i] - arr[i-1]);
            int sJump = Integer.MAX_VALUE;
            if(i > 1){
                sJump = prev2 + Math.abs(arr[i] - arr[i-2]);
            }
            prev2 = prev1;
            prev1 = Math.min(fJump, sJump);
        }
        return prev1;
    }

    /**
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @param index
     * @param dp
     * @return
     */
    private static int findMinCostMemoization(int[] arr, int index, int[] dp) {

        if(index <= 0){
            return 0;
        }

        if(dp[index] != 0){
            return dp[index];
        }

        int firstJump = findMinCostMemoization(arr, index-1, dp) + Math.abs(arr[index] - arr[index-1]);
        int secondJump = Integer.MAX_VALUE;
        if(1 < index){
            secondJump = findMinCostMemoization(arr, index-2, dp) + Math.abs(arr[index] - arr[index-2]);
        }

        int min = Math.min(firstJump, secondJump);
        dp[index] = min;

        return min;
    }

}