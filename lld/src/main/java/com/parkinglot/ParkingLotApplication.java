package com.parkinglot;

import com.parkinglot.controllers.TicketController;
import com.parkinglot.dto.GenerateTicketRequest;
import com.parkinglot.dto.GenerateTicketResponse;
import com.parkinglot.exceptions.GateNotFoundException;
import com.parkinglot.exceptions.VehicleNotFoundException;
import com.parkinglot.model.Gate;
import com.parkinglot.model.ParkingAttendant;
import com.parkinglot.model.Vehicle;
import com.parkinglot.model.VehicleType;
import com.parkinglot.services.EntryGateService;
import lombok.extern.slf4j.Slf4j;

/**
 * ParkingLotApplication is the main entry point for the parking lot system.
 * It initializes the system by creating a vehicle, parking attendant,
 * entry gate, and entry gate service.
 * It then generates a parking ticket for the vehicle
 * using the ticket controller.
 */
@Slf4j
public class ParkingLotApplication {

    public static void main(String[] args) {

        Vehicle suv = Vehicle.builder().vehicleType(VehicleType.CAR).registrationNumber("2322").build();

        ParkingAttendant pa = ParkingAttendant.builder().name("Srinath").email("srinath@gmail.com").build();

        Gate entryGate = Gate.builder().gateNumber(1).parkingAttendant(pa).build();

        EntryGateService entryGateService = new EntryGateService();

        TicketController controller = new TicketController(entryGateService);

        try {
            GenerateTicketResponse response = controller.generateTicket(GenerateTicketRequest.builder().vehicle(suv).gate(entryGate).build());
            log.info("Ticket response : {}", response.getTicket());
        } catch (GateNotFoundException | VehicleNotFoundException e) {
            log.error("Error generating ticket: {}", e.getMessage());
        }
    }

}