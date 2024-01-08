package com.parkinglot.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParkingAttendant {

    private String name;

    private String email;
}
