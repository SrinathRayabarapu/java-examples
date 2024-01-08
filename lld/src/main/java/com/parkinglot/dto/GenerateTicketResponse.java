package com.parkinglot.dto;

import com.parkinglot.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// alternatively you can use builder design pattern but it's a overkill here
public class GenerateTicketResponse {

    private Ticket ticket;

}
