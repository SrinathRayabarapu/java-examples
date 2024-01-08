package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * nums = [2,7,11,15], target = 26
 *
 */
@Slf4j
public class FindIndexesInArrayForAGivenSumMain {

    public static void main(String[] args) {

        int[] input = {2,7,11,15};
        int target = 13;

        int[] output = twoSumInSortedArray(input, target);
        log.info(Arrays.toString(output));


        int[] input1 = {2,17,15,11,0,1};
        int target1 = 28;

        output = twoSumInUnSortedArray(input1, target1);
        log.info(Arrays.toString(output));

    }

    public static int[] twoSumInUnSortedArray(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i =0; i<nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[0];
    }



    // only works if given array is sorted
    public static int[] twoSumInSortedArray(int[] nums, int target) {

        int i = 0;
        int j = nums.length - 1;

        while( i < j){
            if(nums[i] + nums[j] == target){
                return new int[]{i , j};
            } else if(nums[i] + nums[j] > target){
                j--;
            } else {
                i++;
            }
        }

        return new int[0];
    }
}
