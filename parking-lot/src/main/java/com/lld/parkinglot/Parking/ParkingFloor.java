package com.lld.parkinglot.Parking;

import java.util.List;
import java.util.UUID;

public class ParkingFloor {
    private final int ID;
    private final List<ParkingSpot> parkingSpotList;

    public ParkingFloor(int floorNo,List<ParkingSpot> parkingSpotList){
        this.ID = floorNo;
        this.parkingSpotList = parkingSpotList;
        for(ParkingSpot parkingSpot : this.parkingSpotList){
            parkingSpot.setFloorNo(this.ID);
        }
    }

    public boolean isFull(ParkingSpotType spotType){
       return findFreeParkingSpot(spotType) == null;
    }

    public ParkingSpot findFreeParkingSpot(ParkingSpotType spotType){
        for(ParkingSpot parkingSpot : parkingSpotList){
            if(!parkingSpot.isOccupied() && parkingSpot.getType() == spotType){
                return parkingSpot;
            }
        }
        return null;
    }
}
