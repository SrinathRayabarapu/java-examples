package com.dsalgo.arrays;

public class FindMaxLengthOf1sSwapping0With1 {

    public static void main(String[] args) {

        // usecase 1 : where you have extra 1's available in isolation. No. of 1's are NOT same as array length-1
        int[] inputArray1 = {1, 1, 0, 1, 0, 1, 0, 1, 1};
        // in this case the solution is same as FindMaxLengthOf1sReplacing0With1 if you think about it

        // usecase 2 : where you don't have extra 1's available. No. of 1's are same as array length-1
        int[] inputArray2 = {1, 1, 1, 1, 0, 1, 1, 1, 1};
        // in this case it will be different, just ls+rs

        // step 1: find no. of 1's
        int oc = 0;
        for (int i = 0; i < inputArray2.length; i++) {
            if(inputArray2[i] == 1){
                oc++;
            }
        }

        // step 2:
        if(oc == inputArray2.length-1){
            int ans = 0;
            for (int i = 0; i < inputArray2.length; i++) {
                if(inputArray2[i] == 0){
                    int j=i-1;
                    int lc=0;
                    while (j >= 0 && inputArray2[j] == 1){
                        lc++;
                        j--;
                    }
                    int rc=0;
                    j=i+1;
                    while (j < inputArray2.length && inputArray2[j] == 1){
                        rc++;
                        j++;
                    }
                    ans = Math.max(ans, lc+rc);
                }
            }
            System.out.println("Max length is : " + ans);
        } else {
            // follow the FindMaxLengthOf1sReplacing0With1 solution
        }

    }

}