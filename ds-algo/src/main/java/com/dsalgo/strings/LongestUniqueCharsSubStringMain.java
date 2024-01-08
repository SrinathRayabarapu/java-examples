package com.dsalgo.strings;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * given a string, find longest substring without repeating characters
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class LongestUniqueCharsSubStringMain {

    public static void main(String[] args) {

        String input = "pww123kew12";

        int length = findLongestSubStringWithoutRepeatingCharacters(input);
        log.info("Longest substring without repeating chars length : {}", length);
    }

    /**
     * TC: O(n)
     * SC: O(n)
     *
     * @param input
     * @return
     */
    private static int findLongestSubStringWithoutRepeatingCharacters(String input) {

        if(input.length() < 2){
            return input.length();
        }

        int i=0;
        int j=0;
        int max=0;

        Set<Character> set = new HashSet<>();

        String maxSubString = ""; //optional

        while (i < input.length()){
            char c = input.charAt(i);

            while (set.contains(c)){
                set.remove(input.charAt(j++));
            }
            set.add(c);
            maxSubString = input.substring(j, i+1); // optional
            max = Math.max(max, i-j+1);
            i++;
        }

        log.info("SubString : {}", maxSubString);

        return max;
    }

}