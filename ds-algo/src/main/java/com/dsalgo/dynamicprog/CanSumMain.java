package com.dsalgo.dynamicprog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * write a function that takes in a targetSum and array of numbers as argument and calculates whether the targetSum can be
 * calculated with the array numbers.
 *
 * @author srinathr
 */
public class CanSumMain {

    private static final Logger LOG = LoggerFactory.getLogger(CanSumMain.class);

    public static void main(String[] args) {

        int[] numbers = {5, 3, 4, 7};
        int targetSum = 7;

        LOG.info("Start..");
        boolean bool = canSum(targetSum, numbers);
        LOG.info("CanSum of 7 : {}", bool);


        int[] numbers1 = {7, 14};
        targetSum = 300;

        bool = canSum(targetSum, numbers1);
        LOG.info("CanSum of 300 : {}", bool);

        bool = canSumMemoized(targetSum, numbers1, new HashMap<>());
        LOG.info("Memoized CanSum of 300 : {}", bool);


        int[] numbers2 = {8, 7, 17, 9, 19};
        targetSum = 420;

        bool = canSum(targetSum, numbers2);
        LOG.info("CanSum of 420 : {}", bool);

        bool = canSumMemoized(targetSum, numbers2, new HashMap<>());
        LOG.info("Memoized CanSum of 420 : {}", bool);
        LOG.info("End");

    }

    /**
     * TC: O(n*m) where m is target sum and n is array length
     * SC: O(n+m)
     *
     * @param targetSum
     * @param numbers
     * @param cache
     * @return
     */
    private static boolean canSumMemoized(int targetSum, int[] numbers, Map<Integer, Boolean> cache) {

        if(cache.get(targetSum) != null) return cache.get(targetSum);

        if(targetSum == 0) return true;
        if(targetSum < 0) return false;

        for(int num : numbers){
            int reminder = targetSum - num;
            boolean reminderBool = canSumMemoized(reminder, numbers, cache);
            cache.put(reminder, reminderBool);
            if(reminderBool){
                return true;
            }
        }

        return false;
    }

    /**
     * TC: O(n^m) where m is target sum and n is array length
     * SC: O(n+m)
     *
     * @param targetSum
     * @param numbers
     * @return
     */
    private static boolean canSum(int targetSum, int[] numbers) {

        if(targetSum == 0) return true;
        if(targetSum < 0) return false;

        for(int num : numbers){
            int reminder = targetSum - num;
            if(canSum(reminder, numbers)){
                return true;
            }
        }

        return false;
    }

}
