package com.lld.parkinglot.Ticket;

import com.lld.parkinglot.Parking.ParkingSpot;
import com.lld.parkinglot.Payment.PaymentStrategy;
import com.lld.parkinglot.Vehicle.Vehicle;

import java.util.UUID;

public class Ticket {
    private final String ID;
    private final long entryTime;
    private final ParkingSpot parkingSpot;
    private long exitTime;
    private final PaymentStrategy paymentStrategy;

    public Ticket(ParkingSpot parkingSpot,PaymentStrategy paymentStrategy){
        this.ID = UUID.randomUUID().toString();
        this.entryTime = System.currentTimeMillis();
        this.parkingSpot = parkingSpot;
        this.paymentStrategy = paymentStrategy;
    }

    public String getID() {
        return ID;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public long getExitTime() {
        return exitTime;
    }

    public PaymentStrategy getPaymentStrategy(){
        return paymentStrategy;
    }

    public void updateExitTime(){
        this.exitTime = System.currentTimeMillis();
    }
}
