package com.parkinglot.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Gate {

    private int gateNumber;

    private ParkingAttendant parkingAttendant;

    private GateType gateType;
}
