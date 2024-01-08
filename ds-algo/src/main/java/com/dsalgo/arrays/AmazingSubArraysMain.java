package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

/**
 * You are given a string S, and you have to find all the amazing substrings of S.
 * <p>
 * An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
 */
@Slf4j
public class AmazingSubArraysMain {

    public static void main(String[] args) {
        String input = "ABEC";

        int answer = 0;

        for (int i = 0; i < input.length(); i++) {
            if(isVowel(input.charAt(i))){
                answer += (input.length()-i);
            }
        }
        log.info("Answer is : {}", answer);
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';

    }

}