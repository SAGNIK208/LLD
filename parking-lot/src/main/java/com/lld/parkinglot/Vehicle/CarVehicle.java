package com.lld.parkinglot.Vehicle;

import java.util.UUID;

public class CarVehicle extends Vehicle{
    public CarVehicle(){
        super(UUID.randomUUID().toString(),VehicleType.CAR);
    }
}
