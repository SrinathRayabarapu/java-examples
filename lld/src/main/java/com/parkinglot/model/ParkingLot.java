package com.parkinglot.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ParkingLot {

    private String name;

    private String address;

    private List<ParkingFloor> parkingFloors;

    private List<Gate> entryGates;

    private List<Gate> exitGates;
}
