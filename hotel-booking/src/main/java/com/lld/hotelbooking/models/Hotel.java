package com.lld.hotelbooking.models;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Hotel {
    private final String ID;
    private String name;
    private Location location;
    private Map<String,Room> rooms;
    public Hotel(String name,Location location){
        this.ID = UUID.randomUUID().toString();
        this.location = location;
        this.rooms = new HashMap<>();
    }

    public  void updateRooms(String id,Room room){
        this.rooms.put(id,room);
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Map<String, Room> getRooms() {
        return rooms;
    }

    public void setRooms(Map<String, Room> rooms) {
        this.rooms = rooms;
    }
}
