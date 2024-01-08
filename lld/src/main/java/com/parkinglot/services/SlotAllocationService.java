package com.parkinglot.services;

import com.parkinglot.model.ParkingSpot;
import com.parkinglot.model.VehicleType;
import com.parkinglot.repositories.ParkingSpotRepository;

public class SlotAllocationService {

    private ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();

    public ParkingSpot findSpot(VehicleType vehicleType) {
        return parkingSpotRepository.findAvailableParkingSpot(vehicleType);
    }

    public void saveSpot(ParkingSpot parkingSpot) {
        parkingSpotRepository.saveParkingSpot(parkingSpot);
    }
}
