package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * removing duplicates in following ways:
 * 1. given an sorted array, remove duplicates and print the array
 * 2. given an unsorted array, remove duplicates and print them
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class RemoveDuplicatesInArrayMain {

    public static void main(String[] args) {

//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4};

        /*
        int uniqueArrayLength = removeDuplicatesWithExtraSpace(nums);
        LOG.info("Unique elements with extra space : {}", uniqueArrayLength);

        uniqueArrayLength = removeDuplicatesWithoutExtraSpace(nums);
        LOG.info("Unique elements without extra space : {}", uniqueArrayLength);
        */

        int[] nums1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4};
        int uniqueArrayLength = removeDuplicatesWithConstantExtraSpaceBest(nums1);
        log.info("BEST Unique elements with constant space : {}", uniqueArrayLength);
        log.info("Modified Array : {}", Arrays.toString(nums1));

        // returns unique elements count
//        int uniqueArrayLength = bestRemoveDuplicatesWithoutExtraSpace(nums1);
//        log.info("BEST Unique elements without extra space : {}", uniqueArrayLength);
//        log.info(Arrays.toString(nums1));

//        int[] num2 = {2, 3, 1, 2, 3};
//        findDuplicates(num2);
    }

    /**
     * TC: O(n)
     * SC : O(1)
     */
    private static int removeDuplicatesWithConstantExtraSpaceBest(int[] nums1) {

        int length = nums1.length;

        if(length == 0 || length == 1){
            return length;
        }

        int j=0;
        for (int i = 0; i < length-1; i++) {
            if(nums1[i] != nums1[i+1]){ // if unique, copy i value to j and increment j. j is the pointer at which we copy unique value
                nums1[j++] = nums1[i];
            }
        }

        nums1[j++] = nums1[length-1];

        return j;
    }

    // TODO - understand this
    private static void findDuplicates(int[] arr) {
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] % arr.length;
            if(arr[index] / arr.length == 1){
                found = true;
                System.out.print(index+" ");
            }
            arr[index] = arr[index] + arr.length;
        }
        if(!found){
            System.out.println(-1);
        }
    }

    /**
     * Good in runtime. Copied from submitted solutions.
     *
     * @param nums
     * @return
     */
    private static int bestRemoveDuplicatesWithoutExtraSpace(int[] nums) {

        if (nums.length == 0)
            return 0;

        //slow pointer
        int i = 0;
        //fast pointer - j
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * create a temp array and store the unique elements in there.
     *
     * @param nums
     * @return
     */
    private static int removeDuplicatesWithoutExtraSpace(int[] nums) {

        int length = nums.length;

        if (length == 0 || length == 1) {
            return length;
        }

        int j = 0;
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] != nums[i + 1])
                nums[j++] = nums[i];

        nums[j++] = nums[length - 1];

        log.info("Unique elements array : {}", nums);
        return j;
    }

    /**
     * method don't use extra space and only compares i and i+1 element and replace back the unique value.
     *
     * @param nums the nums int array
     */
    private static int removeDuplicatesWithExtraSpace(int[] nums) {
        int length = nums.length;

        if (length == 0 || length == 1) {
            return length;
        }

        int j = 0;
        int[] temp = new int[length];

        //compare two elements, if they are not equal then increment a counter
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] != nums[i + 1])
                temp[j++] = nums[i];

        // observe above, only nums[i] value is being copied, hence copy the last element as well
        temp[j++] = nums[length - 1];

        log.info("Unique elements array : {}", temp);

        return j;
    }

}