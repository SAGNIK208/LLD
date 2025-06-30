package com.lld.hotelbooking.models;

import java.util.UUID;

public abstract class Room {
    private final String ID;
    private final String hotelId;
    protected RoomType roomType;
    public Room(String hotelId){
        ID = UUID.randomUUID().toString();
        this.hotelId = hotelId;
    }

    public String getID() {
        return ID;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "Room{" +
                "ID='" + ID + '\'' +
                ", hotelId='" + hotelId + '\'' +
                ", roomType=" + roomType +
                '}';
    }
}
