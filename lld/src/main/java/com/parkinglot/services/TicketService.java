package com.parkinglot.services;

import com.parkinglot.model.Gate;
import com.parkinglot.model.ParkingSpot;
import com.parkinglot.model.Ticket;
import com.parkinglot.model.Vehicle;
import com.parkinglot.repositories.TicketRepository;

import java.util.Date;
import java.util.Random;

/**
 * Service class responsible for ticket-related operations in the parking lot system.
 * 
 * <p>This service encapsulates all business logic related to parking tickets,
 * including creation, validation, and persistence.</p>
 * 
 * <h3>Responsibilities:</h3>
 * <ul>
 *   <li>Creating new parking tickets</li>
 *   <li>Generating unique ticket IDs</li>
 *   <li>Recording entry time and associated gate</li>
 *   <li>Persisting tickets via the repository</li>
 * </ul>
 * 
 * @author Srinath.Rayabarapu
 * @see Ticket
 * @see TicketRepository
 */
public class TicketService {

    /** Repository for persisting ticket data. */
    private TicketRepository ticketRepository = new TicketRepository();

    /**
     * Creates a new parking ticket for a vehicle.
     * 
     * <p>This method generates a ticket with:</p>
     * <ul>
     *   <li>Unique ticket ID</li>
     *   <li>Current timestamp as entry time</li>
     *   <li>Associated gate and attendant information</li>
     *   <li>Assigned parking spot</li>
     * </ul>
     *
     * @param vehicle the vehicle being parked
     * @param gate the entry gate where ticket is issued
     * @param parkingSpot the allocated parking spot
     * @return the created ticket with all details populated
     */
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
