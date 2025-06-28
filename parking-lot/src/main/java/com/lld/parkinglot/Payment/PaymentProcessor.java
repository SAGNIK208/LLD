package com.lld.parkinglot.Payment;

import com.lld.parkinglot.Parking.ParkingSpot;
import com.lld.parkinglot.Parking.ParkingSpotType;
import com.lld.parkinglot.Ticket.Ticket;
import com.lld.parkinglot.Vehicle.VehicleType;

public class PaymentProcessor {
    public static boolean processPayment(Ticket ticket, PaymentMethod paymentMethod){
        long duration = ticket.getExitTime() - ticket.getEntryTime();
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        ParkingSpotType parkingSpotType = parkingSpot.getType();
        VehicleType vehicleType = parkingSpot.getCurrentVehicle().getType();
        PaymentStrategy paymentStrategy = ticket.getPaymentStrategy();
        double amount = paymentStrategy.calculateAmount(duration,vehicleType,parkingSpotType);
        return paymentMethod.pay(amount);
    }
}
