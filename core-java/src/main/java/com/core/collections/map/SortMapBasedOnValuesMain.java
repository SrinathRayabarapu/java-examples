package com.core.collections.map;


import java.util.*;

/**
 * sort map based on values
 * https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/
 *
 * @author Srinath.Rayabarapu
 */
public class SortMapBasedOnValuesMain {

    public static void main(String[] args) {

        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("seven", 7);
        inputMap.put("one", 1);
        inputMap.put("four", 4);
        inputMap.put("two", 2);
        inputMap.put("five", 5);
        inputMap.put("three", 3);
        inputMap.put("six", 6);

        Map<String, Integer> stringIntegerMap = sortByValue(inputMap);
        System.out.println(stringIntegerMap);
    }

    private static Map<String, Integer> sortByValue(Map<String, Integer> stringMap) {
        Set<Map.Entry<String, Integer>> entries = stringMap.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(entries);

        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));

        Map<String, Integer> map = new LinkedHashMap<>();
        list.forEach(o -> map.put(o.getKey(), o.getValue()));
        return map;
    }

}