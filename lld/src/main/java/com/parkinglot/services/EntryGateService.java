package com.parkinglot.services;

import com.parkinglot.model.Gate;
import com.parkinglot.model.ParkingSpot;
import com.parkinglot.model.Ticket;
import com.parkinglot.model.Vehicle;

import java.util.Objects;

public class EntryGateService {

    private SlotAllocationService slotAllocationService = new SlotAllocationService();

    private TicketService ticketService = new TicketService();

    public Ticket createTicket(Gate gate, Vehicle vehicle) {
        ParkingSpot parkingSpot = slotAllocationService.findSpot(vehicle.getVehicleType());

        if(Objects.isNull(parkingSpot)){
            throw new NoParkingSpotException("Parking spot not found");
        }

        Ticket ticket = ticketService.createTicket(vehicle, gate, parkingSpot);
        slotAllocationService.saveSpot(parkingSpot);

        return ticket;
    }
}
