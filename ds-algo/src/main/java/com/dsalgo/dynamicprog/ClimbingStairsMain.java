package com.dsalgo.dynamicprog;

/**
 * given the number of staircases and steps that you can take, find out the number of ways that you
 * can reach the top.
 * <p>
 *
 * Count ways to reach the n'th stair
 * https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 *
 * <Fibinocci series problem>
 * @author Srinath.Rayabarapu
 */
public class ClimbingStairsMain {

    public static void main(String[] args) {

        int staircaseSteps = 4;
        int ways = 0;

        // using simple recursion
        ways = recursiveApproach(staircaseSteps);
        System.out.println(ways);

        // using memoization
        ways = recursiveMemoization(staircaseSteps, new int[staircaseSteps + 1]);
        System.out.println(ways);

    }

    private static int recursiveMemoization(int staircaseSteps, int[] memo) {
        if (staircaseSteps < 0) {
            return 0;
        } else if (staircaseSteps == 0) {
            return 1;
        }
        if(memo[staircaseSteps] == 0){
            memo[staircaseSteps] = recursiveApproach(staircaseSteps - 1) + recursiveApproach(staircaseSteps - 2);
        }
        // you can take only 1 or 2 steps at a time
        return memo[staircaseSteps];
    }

    private static int recursiveApproach(int staircaseSteps) {
        if (staircaseSteps < 0) {
            return 0;
        } else if (staircaseSteps == 0) {
            return 1;
        }
        // you can take only 1 or 2 steps at a time
        return recursiveApproach(staircaseSteps - 1) + recursiveApproach(staircaseSteps - 2);
    }

}