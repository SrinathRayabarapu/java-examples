package com.parkinglot.services;

import com.parkinglot.model.Gate;
import com.parkinglot.model.ParkingSpot;
import com.parkinglot.model.Ticket;
import com.parkinglot.model.Vehicle;
import com.parkinglot.repositories.TicketRepository;

import java.util.Date;
import java.util.Random;

public class TicketService {

    private TicketRepository ticketRepository = new TicketRepository();

    public Ticket createTicket(Vehicle vehicle, Gate gate, ParkingSpot parkingSpot) {

        Ticket ticket = Ticket.builder()
                .id(String.valueOf(new Random().nextInt(10000)))
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
