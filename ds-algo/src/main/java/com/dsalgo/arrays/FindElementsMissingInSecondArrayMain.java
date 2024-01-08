package com.dsalgo.arrays;

/**
 * given two arrays, find missing elements in second array
 *
 * @author Srinath.Rayabarapu
 */
public class FindElementsMissingInSecondArrayMain {

    public void findMissingElements(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            boolean isFound = false;
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j])
                    isFound = true;
            }
            if (!isFound)
                System.out.println(array1[i]);
        }
    }

    public static void main(String[] args) {
        FindElementsMissingInSecondArrayMain array = new FindElementsMissingInSecondArrayMain();
        int[] array1 = {1, 2, 4};
        int[] array2 = {1, 2};
        array.findMissingElements(array1, array2);
    }

}