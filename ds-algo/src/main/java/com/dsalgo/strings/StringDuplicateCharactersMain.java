package com.dsalgo.strings;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * given a string,
 * 1. removes duplicate characters
 * 2. print number of duplicates with their counts
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class StringDuplicateCharactersMain {

    public static void main(String[] args) {
        String input = "aacccddddeeeegfggssss";

        //output: acdegfs
        removeDuplicatesUsingHashSet(input);
        removeDuplicatesUsingArrays(input);

        printDuplicatesWithCount(input);
        printMaxDuplicateWithCount(input);

        String uniqueCharsString = removeDuplicateCharsFromString(input);
        log.info("Unique chars string : {}", uniqueCharsString);

        log.info("Input : {}", input);

        int uniqueCharCount = 2;
        uniqueCharsString = removeDuplicateCharsFromStringWithCharCount(input, uniqueCharCount);
        log.info("Unique chars string with count : {}", uniqueCharsString);

        uniqueCharsString = removeAdjacentDuplicateCharacters(input);
        log.info("After adjacent chars removal : {}", uniqueCharsString);

    }

    /**
     * example : aabccba
     *
     * @param input
     * @return
     */
    private static String removeAdjacentDuplicateCharacters(String input) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == input.charAt(i)){
                stack.pop();
            } else {
                stack.push(input.charAt(i));
            }
        }

        String output = "";
        while (!stack.isEmpty()){
            output = stack.pop() + output;
        }

        return output;
    }

    private static String removeDuplicateCharsFromStringWithCharCount(String input, int uniqueCharCount) {

        Set<Character> hashSet = new HashSet<>();
        String output = "";
        int tempCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if(!hashSet.contains(input.charAt(i))){
                tempCount = uniqueCharCount;
                output += input.charAt(i);
                tempCount--;
                hashSet.add(input.charAt(i));
            } else {
                if(tempCount > 0){
                    output += input.charAt(i);
                    tempCount--;
                }
            }
        }
        return output;
    }

    private static String removeDuplicateCharsFromString(String input) {

        Set<Character> hashSet = new HashSet<>();
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            if(!hashSet.contains(input.charAt(i))){
                output += input.charAt(i);
                hashSet.add(input.charAt(i));
            }
        }
        return output;
    }

    /**
     * it prints only last max char with count
     *
     * @param input
     */
    private static void printMaxDuplicateWithCount(String input) {
        int[] asciiArray = new int[256];
        for (char c : input.toCharArray()) { // O(n) time
            asciiArray[c]++;
        }
        char maxDuplicate = ' ';
        int count=0;
        for (int i = 0; i < asciiArray.length; i++) { //constant time i.e 256
            if (asciiArray[i] != 0) {
                maxDuplicate = (char) i;
                if(count < asciiArray[i]){
                    count = asciiArray[i];
                }
            }
        }
        System.out.printf("%s is max with count %d", maxDuplicate, count);
    }

    private static void printDuplicatesWithCount(String input) {
        int[] asciiArray = new int[256];
        for (char c : input.toCharArray()) { // O(n) time
            asciiArray[c]++;
        }
        for (int i = 0; i < asciiArray.length; i++) { //constant time
            if(asciiArray[i] != 0){
                System.out.printf("%s with count : %d%n", (char)i, asciiArray[i]);
            }
        }
    }

    // original string character order is not maintained
    private static void removeDuplicatesUsingArrays(String input) {
        int[] asciiArray = new int[256];
        for (char c : input.toCharArray()) { // O(n) time
            asciiArray[c]++;
        }
        String unique = "";
        for (int i = 0; i < asciiArray.length; i++) { //constant time
            if(asciiArray[i] != 0){
                unique = unique + (char)i;
            }
        }
        System.out.println(unique);
    }

    // original string character order is not maintained
    private static void removeDuplicatesUsingHashSet(String input) {
        Set<Character> charSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            charSet.add(c);
        }
        System.out.println(charSet);
    }

}
