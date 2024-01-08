package com.puzzles;

/**
 * TODO - split problems in to three
 *
 * another: list of strings, find strings with their counts and if counts matches sort based aplha and return last
 *
 * @author Srinath.Rayabarapu
 */
public class MaxDifferenceInArrayMain {

    public static void main(String[] args) {

/*
        double d = 10.0/-0;
        System.out.println(d == Double.POSITIVE_INFINITY);
*/

/*
        int[] intArray = {4, 1, 2, 3}; // 2
//        int[] intArray = {5, 4, 3, 2, 1}; // -1

        int min = Integer.MAX_VALUE;
        int max = -1;
        int minIndex = -1;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] < min) {
                min = intArray[i];
                minIndex = i;
            }
            if (max < intArray[i] && minIndex < i) {
                max = intArray[i];
            }
        }
        System.out.println("max : " + max + ", min : " + min);
        System.out.println("Diff : " + ((max == -1) ? max : (max - min)));*/
/*
        int[] intArray = {7, 2, 3, 10, 2, 4, 8, 1}; // 2
        int i = maxDiff(intArray);
        System.out.println(i);
*/

        int[] a = {-5, 4, -2, 3, 1, -1, -6, -1, -6, -1, 0, 5}; //8
        int[] b = {-5, 4, -2, 3, 1}; //6
        int[] c = {-5, 4, -2, 3, 1, -1, -6, -1, 0, -5}; //13

        int min = findMinimumNumber(a);
        System.out.println(min);


    }

    private static int findMinimumNumber(int[] a) {
        int minVal = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] < 0) {
                minVal = minVal + (-a[i]);
            } else {
                minVal = minVal - (a[i]);
            }
        }
        if (minVal < -a[0]) {
            return -a[0] + 1;
        }
        System.out.println(minVal);
        return (minVal > 0) ? minVal + 1 : (-minVal - 1);
    }

    /**
     * @param arr
     * @return
     */
    static int maxDiff(int[] arr) {
        int maximumDiff = arr[1] - arr[0];
        int minimum = arr[0];
        int i;
        for (i = 1; i < arr.length; i++) {
            if ((arr[i] - minimum) > maximumDiff)
                maximumDiff = arr[i] - minimum;

            if (arr[i] < minimum)
                minimum = arr[i];
        }
        return maximumDiff;
    }

}