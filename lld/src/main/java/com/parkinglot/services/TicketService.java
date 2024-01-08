package com.parkinglot.services;

import com.parkinglot.model.Gate;
import com.parkinglot.model.ParkingSpot;
import com.parkinglot.model.Ticket;
import com.parkinglot.model.Vehicle;
import com.parkinglot.repositories.TicketRepository;

import java.util.Date;

public class TicketService {

    private TicketRepository ticketRepository = new TicketRepository();

    public Ticket createTicket(Vehicle vehicle, Gate gate, ParkingSpot parkingSpot) {

        Ticket ticket = Ticket.builder()
                .id(String.valueOf(Math.random()))
                .entryTime(new Date())
                .issuingGate(gate)
                .parkingAttendant(gate.getParkingAttendant())
                .vehicle(vehicle)
                .parkingSpot(parkingSpot)
                .build();

        ticketRepository.save(ticket);

        return ticket;
    }

}
