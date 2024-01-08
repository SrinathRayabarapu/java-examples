package com.dsalgo.arrays;

/**
 * Given array: arr
 * 2, 6, 9, 4, 10
 *
 * Find the no. of triplets of indices which arr[i] < arr[j] < arr[k]
 */
public class FindIndicesTripletsInAscendingOrder {

    public static void main(String[] args) {
        int[] inputArray = {2, 6, 9, 4, 10};

//        badTC(inputArray);

        goodTC(inputArray);
    }

    /**
     * Approach: fix an element as middle and then try to find no. of elements less than it on left and no. of elements
     * more than it on right and multiply and return the consolidated value.
     *
     * this is of O(n^2) but we have other approach with Balanced BST which can give O(n logn)
     * @param inputArray
     */
    private static void goodTC(int[] inputArray) {
        int counter = 0;
        for (int i = 0; i < inputArray.length; i++) {

            int ls = 0;
            for(int j=0; j<i; j++){
                if(inputArray[j] < inputArray[i]){
                    ls ++;
                }
            }

            int rs = 0;
            for (int j = i+1; j < inputArray.length; j++) {
                if(inputArray[i] < inputArray[j]){
                    rs ++;
                }
            }
            counter += ls * rs;
        }
        System.out.println("Number of triplets are : " + counter);
    }

    /**
     * TC : n^3
     *
     * @param inputArray
     */
    private static void badTC(int[] inputArray) {
        int counter = 0;
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[i] > inputArray[j]) {
                    continue;
                }
                for (int k = j + 1; k < inputArray.length; k++) {
                    if (inputArray[j] < inputArray[k]) {
                        counter++;
                    }
                }
            }
        }
        System.out.println("Number of triplets are : " + counter);
    }

}