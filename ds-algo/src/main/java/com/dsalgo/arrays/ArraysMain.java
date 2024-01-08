package com.dsalgo.arrays;

/**
 * practice Arrays
 *
 * @author Srinath.Rayabarapu
 */
public class ArraysMain {

    public static void main(String[] args) {
//		testArrays();

        //TODO - do the array in-place multiple value replace puzzle

    }

    private static void testArrays() {
        int[] a = new int[3];
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}