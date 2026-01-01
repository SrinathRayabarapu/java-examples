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
 * Main entry point for the Parking Lot Management System.
 * 
 * <p>This application demonstrates a Low-Level Design (LLD) implementation
 * of a parking lot system, commonly asked in system design interviews.</p>
 * 
 * <h3>System Components:</h3>
 * <ul>
 *   <li><b>Controllers</b> - Handle incoming requests and format responses</li>
 *   <li><b>Services</b> - Contain business logic for ticket and gate management</li>
 *   <li><b>Repositories</b> - Manage data persistence</li>
 *   <li><b>Models</b> - Domain entities (Vehicle, Ticket, Gate, etc.)</li>
 * </ul>
 * 
 * <h3>Key Features:</h3>
 * <ul>
 *   <li>Vehicle entry and ticket generation</li>
 *   <li>Multiple vehicle types support (CAR, BIKE, TRUCK)</li>
 *   <li>Gate and attendant management</li>
 *   <li>Slot allocation strategies</li>
 * </ul>
 * 
 * <h3>Design Patterns Used:</h3>
 * <ul>
 *   <li>Builder Pattern - For creating complex domain objects</li>
 *   <li>Repository Pattern - For data access abstraction</li>
 *   <li>Service Layer Pattern - For business logic encapsulation</li>
 *   <li>DTO Pattern - For clean API contracts</li>
 * </ul>
 * 
 * @author Srinath.Rayabarapu
 * @see TicketController
 * @see EntryGateService
 */
@Slf4j
public class ParkingLotApplication {

    /**
     * Main method that demonstrates the parking lot system workflow.
     * 
     * <p>This method simulates a vehicle entering the parking lot:</p>
     * <ol>
     *   <li>Creates a vehicle with type and registration number</li>
     *   <li>Sets up a parking attendant at the entry gate</li>
     *   <li>Configures the entry gate with the attendant</li>
     *   <li>Uses the ticket controller to generate a parking ticket</li>
     * </ol>
     *
     * @param args command-line arguments (not used)
     */
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