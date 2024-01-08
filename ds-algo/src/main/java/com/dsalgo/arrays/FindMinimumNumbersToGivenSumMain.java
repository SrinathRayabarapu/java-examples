package com.dsalgo.arrays;

/**
 * given a sum, find the minimum number of multiples of an array
 *
 * @author Srinath.Rayabarapu
 */
public class FindMinimumNumbersToGivenSumMain {

    public static void main(String[] args) {

        // given sum
        int sum = 22;

        // numbers array
        int[] arr = {1, 3, 5};

        System.out.println(findMinimumNumbers(arr, sum));
    }

    private static int findMinimumNumbers(int[] arr, int sum) {

        int count = 0;

        for (int i = arr.length-1; i >= 0; i--) {
            if(sum%arr[i] == 0){
                count = count + sum/arr[i];
                return count;
            } else {
                count = count + sum/arr[i];
            }
            // decrement the sum
            sum = sum%arr[i];
        }

        count += sum;

        return count;
    }

}