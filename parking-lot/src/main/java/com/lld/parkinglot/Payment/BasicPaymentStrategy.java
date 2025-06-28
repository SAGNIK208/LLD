package com.lld.parkinglot.Payment;

import com.lld.parkinglot.Parking.ParkingSpotType;
import com.lld.parkinglot.Vehicle.VehicleType;

public class BasicPaymentStrategy implements PaymentStrategy{
    @Override
    public double calculateAmount(long duration, VehicleType vehicleType, ParkingSpotType parkingSpotType) {
        return 10.0;
    }
}
