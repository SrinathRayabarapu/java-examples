package com.puzzles;

/**
 * given total units of distance, initial energy, distances of stalls array and energy juice quantity at each
 * stall, find the minimum number of stalls to cover complete distance.
 *
 * @author Srinath.Rayabarapu
 */
public class NumberOfStallVisitedMain {

    public static void main(String[] args) {
        int numberOfStalls = 4;
        int[] distanceOfStalls = {5, 7, 8, 10};
        int[] juiceQuantity = {2, 3, 1, 5};
        int totalDistance = 15;
        int initialEnergy = 5;

        int min = findMinNumberOfJuiceStalls(numberOfStalls, distanceOfStalls, juiceQuantity, totalDistance,
                initialEnergy);
        System.out.println(min);
    }

    /**
     * traverse through each stall distance and add the energy points to current location and check whether
     * it's equal to total distance or not. Have a counter incremented whenever we visit a stall.
     *
     * @param numOfStalls
     * @param distOfStalls
     * @param juiceQuty
     * @param distance
     * @param initialEnergy
     * @return
     */
    private static int findMinNumberOfJuiceStalls(int numOfStalls, int[] distOfStalls, int[] juiceQuty,
                                                  int distance, int initialEnergy) {
        int currentLocation = initialEnergy;
        int visitedCount = 0;
        for (int i = 0; i < distOfStalls.length; i++) {
            if (currentLocation == distOfStalls[i]) {
                currentLocation = currentLocation + juiceQuty[i];
                visitedCount++;
                if (currentLocation == distance) {
                    return visitedCount;
                }
            }
        }
        return -1;
    }

}