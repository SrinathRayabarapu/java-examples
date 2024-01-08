package com.parkinglot.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Ticket {

    private String id;

    private Date entryTime;

    private ParkingSpot parkingSpot;

    private Gate issuingGate;

    private ParkingAttendant parkingAttendant;

    private Vehicle vehicle;

}