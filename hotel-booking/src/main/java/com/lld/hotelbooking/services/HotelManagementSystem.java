package com.lld.hotelbooking.services;

import com.lld.hotelbooking.models.Hotel;
import com.lld.hotelbooking.models.Room;
import com.lld.hotelbooking.models.User;

import java.util.*;

public class HotelManagementSystem {
    private Map<String,Hotel> hotels;
    private final ReservationSystem reservationSystem;
    public HotelManagementSystem(){
        this.hotels = new HashMap<>();
        this.reservationSystem = new ReservationSystem(new ReservationLockProvider(5000));
    }

    public void addHotel(Hotel hotel){
        this.hotels.put(hotel.getID(),hotel);
    }

    public void reservedBookings(){
        reservationSystem.printReservedBookings();
    }

    public List<Room> roomsAvailable(String hotelId, Date startDate, Date endDate){
        Hotel hotel = hotels.get(hotelId);
        List<String> roomsBooked = reservationSystem.roomsBooked(hotelId,startDate,endDate);
        List<Room> rooms = new ArrayList<>(hotel.getRooms().values());
        List<Room> roomsAvailable = new ArrayList<>();
        for(Room room : rooms){
            if(!roomsBooked.contains(room.getID())){
                roomsAvailable.add(room);
            }
        }
        return roomsAvailable;
    }

    public void bookRooms(String hotelId, List<String> roomIds, Date startDate, Date endDate, User user){
        List<Room> roomsAvailable = roomsAvailable(hotelId,startDate,endDate);
        if(!roomIds.stream().allMatch(roomId -> roomsAvailable.stream().anyMatch(room -> room.getID().equals(roomId)))){
            System.out.println("Room is booked ");
            return;
        }
        try{
            reservationSystem.bookRooms(hotelId,roomIds,startDate,endDate,user);
        }catch (Exception e){
            System.out.println("Unable to book the room " + e.getMessage());
        }
    }
}
