package com.puzzles;

/**
 * Your task is to make a function that can take any non-negative integer as a argument and return it with its digits in
 * descending order. Essentially, rearrange the digits to create the highest possible number.
 *
 * codewars.com/kata/5467e4d82edf8bbf40000155/train/java
 *
 * @author srinathrayabarapu
 */
public class NumberDescendingOrderMain {

    public static void main(String[] args) {
        int[] numArray = new int[10];
        int num = 2110;
        int val = 0;
        while (num % 10 != 0){
            val = num % 10;
            if(numArray[val] != 0){
                numArray[val] = numArray[val] + 1;
            } else {
                numArray[val] = 1;
            }
            num = num / 10;
        }
        String finalNumber = "";
        for (int i = numArray.length-1; i >= 0; i--) {
            if(numArray[i] != 0){
                int local = 0;
                while (numArray[i] > local){
                    finalNumber = finalNumber + i;
                    local++;
                }
            }
        }
        System.out.println(finalNumber);
    }



}
