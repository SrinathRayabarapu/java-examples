package com.puzzles;

/**
 * A thief trying to escape from a jail. He has to cross N walls each with varying heights
 * (every height is greater than 0). He climbs X feet every time. But, due to the slippery nature of
 * those walls, every time he slips back by Y feet. Now the task is to calculate the total number of
 * jumps required to cross all walls and escape from the jail.
 *
 * https://www.geeksforgeeks.org/number-of-jumps-for-a-thief-to-cross-walls/
 *
 * @author Srinath.Rayabarapu
 */
public class NumberJumpsThiefCrossWallsMain {

    public static void main(String[] args) {

        int[] intArray = {11, 10, 10, 9};
        int x = 10;
        int y = 1;

        int totalJumps = findNumberOfTotalJumps(intArray, x, y);
        System.out.println(totalJumps);

    }

    private static int findNumberOfTotalJumps(int[] intArray, int x, int y) {

        int diff = x - y;
        int jumps = 0;

        for (int i = 0; i < intArray.length; i++) {
            // assuming when thief jumps to wall height then he is not slipping back
            //if (intArray[i] < diff) {

            if (intArray[i] <= x) {
                jumps++;
                continue;
            }

            if (intArray[i] % diff == 0) {
                jumps += intArray[i] / diff;
            } else {
                jumps += (intArray[i] / diff) + 1;
            }
        }

        return jumps;
    }

}