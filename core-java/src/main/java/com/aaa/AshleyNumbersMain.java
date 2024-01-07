package com.aaa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AshleyNumbersMain {

    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(20);
        list.add(list1);
        list1 = new ArrayList<>();
        list1.add(9);
        list1.add(19);
        list.add(list1);

        countNumbers(list);

    }


    static void countNumbers(List<List<Integer>> arr) {

        for (List<Integer> list : arr){
            int[] collect = IntStream.rangeClosed(list.get(0), list.get(1)).toArray();
            int count = 0;
            for (int intgr : collect){
                count = count + checkNumber(intgr);
            }
            System.out.println(count);
        }

    }

    private static int checkNumber(Integer intgr) {
        String str = intgr+"";
        int[] numArray = new int[256];
        for (char c : (str.toCharArray())){
            if(numArray[c] == 0){
                numArray[c] = numArray[c] + 1;
            } else {
                return 0;
            }
        }
        return 1;
    }

}
