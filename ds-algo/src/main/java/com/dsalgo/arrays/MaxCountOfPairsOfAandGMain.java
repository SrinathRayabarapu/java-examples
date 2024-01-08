package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

/**
 * given a string "bcaggaag" find the count of pairs such that indices of a < g
 *
 * TC: O(n)
 * SC: O(1)
 *
 * Technique is called as Carry Forward also known as Dynamic Programming
 *
 * # L1 - Easy - InterviewQuestion
 */
@Slf4j
public class MaxCountOfPairsOfAandGMain {

    public static void main(String[] args) {

//        String input = "bcaggaag"; // output is 5

        String input = "aaaaaaag"; // output is 7

        double pow = Math.pow(10, 9) + 7;
        int mod = (int) pow;

        int gCount = 0;
        int answer = 0;

        for (int i = input.length()-1; i >= 0; i--) {
            if(input.charAt(i) == 'g'){
                gCount++;
            } else if(input.charAt(i) == 'a'){
                answer += gCount % mod;
            }
        }

        log.info("Answer is : {}", answer);
    }

}
