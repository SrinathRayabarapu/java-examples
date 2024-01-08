package com.parkinglot.services;

public class NoParkingSpotException extends RuntimeException {
    public NoParkingSpotException(String message) {
        super(message);
    }
}
