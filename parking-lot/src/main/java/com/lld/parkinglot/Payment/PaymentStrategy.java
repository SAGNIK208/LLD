package com.lld.parkinglot.Payment;

import com.lld.parkinglot.Parking.ParkingSpotType;
import com.lld.parkinglot.Vehicle.VehicleType;

public interface PaymentStrategy {
    double calculateAmount(long duration, VehicleType vehicleType, ParkingSpotType parkingSpotType);
}
