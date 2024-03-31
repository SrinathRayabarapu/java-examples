package com.dsalgo.arrays.prefixsum;

public class TimeToEqualityMain {

    public static void main(String[] args) {
        int[] array = {2, 4, 1, 3, 2};

        int max = Integer.MIN_VALUE;

        for (int i : array){
            max = Math.max(max, i);
        }
        int totalTime = 0;
        for (int i : array){
            totalTime += max-i;
        }

        System.out.println("Total time : " + totalTime);
    }

}
