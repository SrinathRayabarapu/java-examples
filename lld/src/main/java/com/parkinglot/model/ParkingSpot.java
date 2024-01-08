package com.parkinglot.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParkingSpot {

    private int spotNumber;

    private SpotStatus spotStatus;

    private VehicleType vehicleType;

    private Vehicle vehicle;

}
