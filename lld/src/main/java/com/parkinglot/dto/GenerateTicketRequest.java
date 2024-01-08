package com.parkinglot.dto;

import com.parkinglot.model.Gate;
import com.parkinglot.model.Vehicle;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenerateTicketRequest {

    private Vehicle vehicle;

    private Gate gate;
}
