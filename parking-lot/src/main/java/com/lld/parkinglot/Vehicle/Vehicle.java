package com.lld.parkinglot.Vehicle;

public abstract class Vehicle {
    protected final String license;
    protected final VehicleType type;

    public Vehicle(String license,VehicleType type){
        this.license = license;
        this.type = type;
    }

    public String getLicense() {
        return license;
    }

    public VehicleType getType() {
        return type;
    }
}
