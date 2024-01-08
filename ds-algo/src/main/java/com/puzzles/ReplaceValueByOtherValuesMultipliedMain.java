package com.puzzles;

import java.util.Arrays;

/**
 * given an array, replace each value with remaining values multiplied number
 *
 * idea: multiply all the numbers and divide by each index number and replace
 *
 * Time complexity: O(n)
 *
 * @author Srinath.Rayabarapu
 */
public class ReplaceValueByOtherValuesMultipliedMain {

    public static void main(String[] args) {

        int[] intArray = {1, 4, 6, 11, 9, 21, 5};
        System.out.println("Original Array : " + Arrays.toString(intArray));

        int[] ints = replaceWithMultiples(intArray);
        System.out.println("Modified Array : " + Arrays.toString(ints));

    }

    private static int[] replaceWithMultiples(int[] intArray) {
        int product = 1;
        for(int i : intArray){
            product = product * i;
        }
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = product/intArray[i];
        }
        return intArray;
    }

}
