package com.puzzles;

import java.util.Arrays;
import java.util.List;

/**
 * given an array of +ve and -ve numbers, find what is the minimum health that is needed to start and
 * traverse array till end without health being 0 or less.
 *
 * #FiveTran - Hacker rank puzzle
 *
 * @author Srinath.Rayabarapu
 */
public class DungeonsNDragonsMinHealthMain {

    public static void main(String[] args) {

        // output: 14
        List<Integer> list = Arrays.asList(10, -5, 4, -2, -3, 1, -1, -6, -1, 0, 5);

        // output: 6
//        List<Integer> list = Arrays.asList(5, -5, 4, -2, 3, 1);

        // output: 13
//        List<Integer> list = Arrays.asList(10, -5, 4, -2, 3, 1, -1, -6, -1, 0, -5);

        long minHealth = findMinHealth(list);
        System.out.println(minHealth);
    }

    public static long findMinHealth(List<Integer> dungeon) {

        int energy = 0;
        long totalDiffEnergy = 1;                     //result is one because minimum initial energy

        for (int i = 0; i < dungeon.size(); i++) {

            if (dungeon.get(i) >= 0)
                energy = energy + dungeon.get(i);     //increase energy
            else {
                energy = energy + dungeon.get(i);     //decrease energy
                if (energy < 0) {
                    totalDiffEnergy = totalDiffEnergy + (-energy);   //make count of difference at each level
                    energy = 0;                       //make sum=0, because we have compensated the decrease
                }
            }
        }

        return totalDiffEnergy + dungeon.get(0);
    }

}