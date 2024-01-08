package com.puzzles;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

/**
 * given a 2D array of stating and ending times of meetings, return whether a person can attend all the meetings
 *
 * return boolean true if person can attend. otherwise return false.
 */
@Slf4j
public class MeetingRoomAttendance {

    public static void main(String[] args) {

        int[][] meetings = {{1, 2}, {4, 10}, {2, 4}};

        boolean boool = isItPossible(meetings);

        log.info("Is it possible : {}", boool);
    }

    private static boolean isItPossible(int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));

        int previousEnd = Integer.MIN_VALUE;

        for (int[] meeting : meetings) {
            if (previousEnd > meeting[0]) {
                return false;
            }
            previousEnd = meeting[1];
        }
        return true;
    }

}
