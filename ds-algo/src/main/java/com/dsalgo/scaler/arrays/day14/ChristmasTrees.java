package com.dsalgo.scaler.arrays.day14;

/**
 * You are given an array A consisting of heights of Christmas trees and an array B of the same size
 * consisting of the cost of each of the trees (Bi is the cost of tree Ai, where 1 ≤ i ≤ size(A)), and
 * you are supposed to choose 3 trees (let's say, indices p, q, and r), such that Ap < Aq < Ar, where p < q < r.
 *
 * The cost of these trees is Bp + Bq + Br.
 *
 * You are to choose 3 trees such that their total cost is minimum. Return that cost.
 *
 * If it is not possible to choose 3 such trees return -1.
 */
public class ChristmasTrees {

    //TODO - COMPLETE FOR ALL TESTCASES

    public static void main(String[] args) {

        int[] heightArray = {5, 9, 10, 4, 7, 8};
        int[] costArray =   {5, 6, 4,  7, 2, 5};

        int minCost = calculateMinimumCost(heightArray, costArray);
        System.out.println("minCost = " + minCost);

    }

    private static int calculateMinimumCost(int[] heightArray, int[] costArray) {

        int minCost = Integer.MAX_VALUE;

        // given that minimum size of heightArray is 3
        for (int i = 1; i < heightArray.length-1; i++) {

            // for each tree, look for small height tree on left and tall height tree on right

            int leftMinCost = Integer.MAX_VALUE;
            int rightMinCost = Integer.MAX_VALUE;

            // find small height tree on left
            int leftIndex = i-1;
            int lessHeight = heightArray[i];

            while (0 <= leftIndex){
                if(heightArray[leftIndex] < lessHeight && costArray[leftIndex] < leftMinCost){
                    lessHeight = heightArray[leftIndex];
                    leftMinCost = Math.min(leftMinCost, costArray[leftIndex]);
                }
                leftIndex--;
            }

            // find tall height tree on right
            int rightIndex = i+1;
            int moreHeight = heightArray[i];

            while (rightIndex < heightArray.length){
                if(moreHeight < heightArray[rightIndex] && costArray[i] < rightMinCost){
                    moreHeight = heightArray[rightIndex];
                    rightMinCost = Math.min(rightMinCost, costArray[rightIndex]);
                }
                rightIndex++;
            }

            if (leftMinCost == Integer.MAX_VALUE || rightMinCost == Integer.MAX_VALUE){
                continue;
            }

            System.out.println("i: " + i + ", costArray[i]: " + costArray[i] +", leftMinCost: " + leftMinCost + ", rightMinCost: " + rightMinCost);
            // add cost of current + small + tall trees and assign it to minCost variable and return
            minCost = Math.min(minCost, costArray[i] + leftMinCost + rightMinCost);
            System.out.println("minCost = " + minCost);
        }
        return minCost;
    }

}