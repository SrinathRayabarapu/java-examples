package com.dsalgo.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * given a sum and sorted array, find all elements combinations in an array whose sum is equal
 *
 * @author Srinath.Rayabarapu
 */
public class FindNElementPositionsOfGivenSumMain {

    public static void main(String[] args) {

        int[] intArray = {10, 12, 3, 40, 0, 5, 6, 7, 8, 35, 28, 30};
        int sum = 40;


        System.out.println("While loop way - Not so efficient!");
        // Time complexity: O(nlogn) - approx!?
        loopWithLeftRightPointersApproach(intArray, sum);


        System.out.println("HashMap way - Good one!");
        // Time complexity: O(n)
        hashMapApproach(intArray, sum);

    }

    private static void hashMapApproach(int[] intArray, int sum) {
        Map<Integer, Integer> pairsMap = new HashMap<>();
        for (int i = 0; i < intArray.length; i++) {
            if (pairsMap.containsKey(intArray[i])) {
                System.out.printf("%d , %d\n", intArray[i], pairsMap.get(intArray[i]));
            } else {
                pairsMap.put((sum - intArray[i]), intArray[i]);
            }
        }
    }

    private static void loopWithLeftRightPointersApproach(int[] intArray, int sum) {
        int l = 0, r = intArray.length - 1;
        while (l < r) {
            if (sum < intArray[l] + intArray[r]) {
                r--;
            } else if (sum > intArray[l] + intArray[r]) {
                l++;
            } else {
                System.out.printf("%d, %d\n", intArray[l], intArray[r]);
                l++;
            }
        }
    }

}