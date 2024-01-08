package com.parkinglot.controllers;

import com.parkinglot.dto.GenerateTicketRequest;
import com.parkinglot.dto.GenerateTicketResponse;
import com.parkinglot.exceptions.GateNotFoundException;
import com.parkinglot.exceptions.VehicleNotFoundException;
import com.parkinglot.model.Ticket;
import com.parkinglot.services.EntryGateService;

import java.util.Objects;

public class TicketController {

    private EntryGateService entryGateService;

    public TicketController(EntryGateService entryGateService) {
        this.entryGateService = entryGateService;
    }

    public GenerateTicketResponse generateTicket(GenerateTicketRequest generateTicketRequest) throws GateNotFoundException, VehicleNotFoundException {

        if(Objects.isNull(generateTicketRequest.getGate())){
            throw new GateNotFoundException("No Gate found!!");
        }

        if(Objects.isNull(generateTicketRequest.getVehicle())){
            throw new VehicleNotFoundException("No Vehicle found!!");
        }

        Ticket ticket = entryGateService.createTicket(generateTicketRequest.getGate(), generateTicketRequest.getVehicle());

        return new GenerateTicketResponse(ticket);
    }

}
