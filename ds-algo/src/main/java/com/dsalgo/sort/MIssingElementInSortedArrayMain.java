package com.dsalgo.sort;

/**
 * given an sorted array of sequential numbers, find a missing number.
 *
 * assumptions: starting and ending numbers are boundaries.
 *
 * logic: find expected sum and actual sums and subtract
 *
 * @author Srinath.Rayabarapu
 */
public class MIssingElementInSortedArrayMain {

    public static void main(String[] args) {
        int[] inputArray = {1, 2, 3, 5, 6, 7};

        if(inputArray.length == 0){
            System.out.println("Array in empty!");
            return;
        }

        int lastElement = inputArray[inputArray.length-1];

        // formula for calculating sum - (n * (n+1)/2)
        int expectedSum = (lastElement * (lastElement+1)/2);

        int actualSum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            actualSum = actualSum + inputArray[i];
        }

        System.out.println("missing number : " + (expectedSum - actualSum));

    }

}
