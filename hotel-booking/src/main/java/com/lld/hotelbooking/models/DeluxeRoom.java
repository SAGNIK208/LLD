package com.lld.hotelbooking.models;

public class DeluxeRoom extends Room{

    public DeluxeRoom(String hotelId) {
        super(hotelId);
        this.roomType = RoomType.DELUXE;
    }
}
