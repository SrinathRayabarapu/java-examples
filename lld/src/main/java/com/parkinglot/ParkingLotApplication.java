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

public class ParkingLotApplication {
    public static void main(String[] args) {

        Vehicle suv = Vehicle.builder().vehicleType(VehicleType.CAR).registrationNumber("2322").build();

        ParkingAttendant pa = ParkingAttendant.builder().email("abc@gmail.com").name("abc").build();

        Gate entryGate = Gate.builder().gateNumber(1).parkingAttendant(pa).build();

        EntryGateService entryGateService = new EntryGateService();

        TicketController controller = new TicketController(entryGateService);

        try {
            GenerateTicketResponse response = controller.generateTicket(GenerateTicketRequest.builder().vehicle(suv).gate(entryGate).build());
            System.out.println(response.getTicket());
        } catch (GateNotFoundException | VehicleNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}