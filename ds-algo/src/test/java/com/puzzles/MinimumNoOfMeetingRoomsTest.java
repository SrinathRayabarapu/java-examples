package com.puzzles;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MinimumNoOfMeetingRoomsTest {

    @Test
    void shouldPass() {
        int[][] meetings = {{0, 5}, {4, 5}, {5, 6}};
        MinimumNoOfMeetingRooms minimumNoOfMeetingRooms = new MinimumNoOfMeetingRooms();
        assertEquals(2, minimumNoOfMeetingRooms.minMeetingRooms(meetings));
    }

    @Test
    void shouldFail() {
        int[][] meetings = {{0, 5}, {4, 5}, {5, 6}};
        MinimumNoOfMeetingRooms minimumNoOfMeetingRooms = new MinimumNoOfMeetingRooms();
        assertNotEquals(1, minimumNoOfMeetingRooms.minMeetingRooms(meetings));
    }

}