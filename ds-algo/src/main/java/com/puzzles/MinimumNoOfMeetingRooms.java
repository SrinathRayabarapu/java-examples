package com.puzzles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * given a 2d array of meeting rooms, find minimum no. of rooms that are required to arrange all the meetings
 */
@Slf4j
public class MinimumNoOfMeetingRooms {

    public static void main(String[] args) {

        int[][] meetings = {{0, 5}, {4, 5}, {5, 6}};

        log.info("Minimum meeting rooms needed : {}", new MinimumNoOfMeetingRooms().minMeetingRooms(meetings));

    }

    public int minMeetingRooms(int[][] meetings) {

        List<Event> events = new ArrayList<>();

        int rooms = 0;
        int minRooms = 0;

        for (int[] meeting : meetings){
            events.add(new Event(meeting[0], "start"));
            events.add(new Event(meeting[1], "end"));
        }

        events.sort(Comparator.comparingInt(Event::getStart));

        for (Event event : events) {
            if (event.getPosition().equals("start")) {
                rooms++;
            } else {
                rooms--;
            }

            minRooms = Math.max(minRooms, rooms);
        }

        return minRooms;
    }

}

@AllArgsConstructor
@Setter
@Getter
@ToString
class Event {
    int start;
    String position;
}
