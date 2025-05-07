package com.parkinglot.repositories;

import com.parkinglot.model.ParkingSpot;
import com.parkinglot.model.SpotStatus;
import com.parkinglot.model.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotRepository {

    private final List<ParkingSpot> parkingSpots = new ArrayList<>();

    public ParkingSpotRepository() {
        initializeParkingSpots();
    }

    public ParkingSpot findAvailableParkingSpot(VehicleType vehicleType){
        return parkingSpots.stream()
                .filter(parkingSpot -> parkingSpot.getVehicleType().equals(vehicleType)
                        && parkingSpot.getSpotStatus().equals(SpotStatus.AVAILABLE))
                .findFirst().orElse(null);
    }

    public void saveParkingSpot(ParkingSpot parkingSpot) {
        if(!parkingSpots.contains(parkingSpot)){
            throw new IllegalArgumentException("ParkingSpot is not present!!");
        }

        parkingSpots.forEach(parking -> {
                if (parking.equals(parkingSpot)) {
                    parking.setSpotStatus(SpotStatus.OCCUPIED);
                }
            }
        );
    }

    private void initializeParkingSpots() {

        ParkingSpot autoParkingSpot = ParkingSpot.builder()
                .spotNumber(1)
                .spotStatus(SpotStatus.AVAILABLE)
                .vehicleType(VehicleType.AUTO)
                .build();

        ParkingSpot bikeParkingSpot = ParkingSpot.builder()
                .spotNumber(2)
                .spotStatus(SpotStatus.AVAILABLE)
                .vehicleType(VehicleType.BIKE)
                .build();

        ParkingSpot carParkingSpot = ParkingSpot.builder()
                .spotNumber(2)
                .spotStatus(SpotStatus.AVAILABLE)
                .vehicleType(VehicleType.CAR)
                .build();

        ParkingSpot busParkingSpot = ParkingSpot.builder()
                .spotNumber(2)
                .spotStatus(SpotStatus.AVAILABLE)
                .vehicleType(VehicleType.BUS)
                .build();

        ParkingSpot lorryParkingSpot = ParkingSpot.builder()
                .spotNumber(2)
                .spotStatus(SpotStatus.AVAILABLE)
                .vehicleType(VehicleType.LORRY)
                .build();

        parkingSpots.addAll(List.of(autoParkingSpot, bikeParkingSpot, carParkingSpot, busParkingSpot, lorryParkingSpot));
    }

}
