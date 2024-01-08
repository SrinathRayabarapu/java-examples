package com.dsalgo.arrays;

import lombok.extern.slf4j.Slf4j;

/**
 * A wire connects N light bulbs. Each bulb has a switch associated with it; however, due to faulty wiring,
 * a switch also changes the state of all the bulbs to the right of the current bulb.
 * <p>
 * Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
 * You can press the same switch multiple times.
 * <p>
 * Note: 0 represents the bulb is off and 1 represents the bulb is on.
 */
@Slf4j
public class MinSwitchesForBulbsMain {

    public static void main(String[] args) {

        int[] inputArray = {0, 1, 0, 1};

        int switcher = 0;
        int answer = 0;

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == 0 && switcher == 0) {
                switcher = 1;
                answer++;
            } else if( inputArray[i] == 1 && switcher == 1){
                switcher = 0;
                answer++;
            }
        }

        log.info("Answer is : {}", answer);
    }

}