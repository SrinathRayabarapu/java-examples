package com.dsalgo.arrays;

/**
 * given a binary array, find max length of consecutive 1's by replacing a single 0 with 1
 *
 * TC: O(n)
 * SC: O(1)
 */
public class FindMaxLengthOf1sReplacing0With1 {

    public static void main(String[] args) {
        int[] inputArray = {0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0};

        int ans = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if(inputArray[i] == 0){
                int lc = 0;
                int j = i-1;
                while (j >= 0 && inputArray[j] == 1){
                    lc++;
                    j--;
                }
                j = i+1;
                int rc = 0;
                while (j < inputArray.length && inputArray[j] == 1){
                    rc++;
                    j++;
                }
                ans = Math.max(ans, lc + rc + 1);
            }
        }
        System.out.println("Max length is : " + ans);
    }

}
