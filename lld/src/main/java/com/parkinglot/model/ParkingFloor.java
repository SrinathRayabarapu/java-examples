package com.parkinglot.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ParkingFloor {

    private int floorNumber;

    private List<ParkingSpot> parkingSpots;
}
