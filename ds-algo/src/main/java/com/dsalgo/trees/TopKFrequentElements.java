package com.dsalgo.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You
 * may return the answer in any order.
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * TC: O(n)
 * SC: O(n)
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] inputArray = {1,1,1,2,2,3};
        int k = 2;
//        Output: [1,2]

        // for populating map:: TC=O(n), SC=O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inputArray.length; i++) {
            if(map.get(inputArray[i]) == null){
                map.put(inputArray[i], 1);
            } else {
                map.put(inputArray[i], map.get(inputArray[i]) + 1);
            }
        }

        // for populating indexToValueArray array : O(n)
        int[] indexToValueArray = new int[inputArray.length+1];
        for (int value : map.keySet()){
            indexToValueArray[map.get(value)] = value;
        }

        // finding top k elements : O(k)
        List<Integer> list = new ArrayList<>();
        int reverseIndex = indexToValueArray.length-1;
        while (list.size() < k){
            if(indexToValueArray[reverseIndex] != 0){
                list.add(indexToValueArray[reverseIndex]);
            }
//            System.out.println("list = " + list);
            reverseIndex--;
        }

        // total TC: 2 O(n) + O(k) = O(n)
        System.out.println("list = " + list);
    }

}
