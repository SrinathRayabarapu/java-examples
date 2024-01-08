package com.parkinglot.model;

import lombok.Data;

import java.util.Date;

@Data
public class Invoice {

    private int invoiceId;

    private Date exitTime;

    private Ticket ticket;

    private Double amount;

    private Payment payment;

    private Gate exitGate;

    private ParkingAttendant parkingAttendant;
}
