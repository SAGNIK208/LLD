package com.lld.parkinglot.Parking;

import com.lld.parkinglot.Vehicle.Vehicle;

import java.util.UUID;

public class ParkingSpot {
    private final String ID;
    private boolean isOccupied;
    private int floorNo;
    private final ParkingSpotType type;
    private Vehicle currentVehicle;

    public String getID() {
        return ID;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    public ParkingSpot(ParkingSpotType type){
        ID = UUID.randomUUID().toString();
        isOccupied = false;
        this.type = type;
        this.currentVehicle = null;
    }

    public void setFloorNo(int floorNo){
        this.floorNo = floorNo;
    }

    public boolean isOccupied(){
        return this.isOccupied;
    }

    public void occupy(Vehicle vehicle){
        this.currentVehicle = vehicle;
        this.isOccupied = true;
    }

    public void unOccupy() {
        this.currentVehicle = null;
        this.isOccupied = false;
    }

}
