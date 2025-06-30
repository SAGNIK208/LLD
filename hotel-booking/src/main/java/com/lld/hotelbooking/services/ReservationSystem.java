package com.lld.hotelbooking.services;

import com.lld.hotelbooking.models.Reservation;
import com.lld.hotelbooking.models.User;

import java.util.*;

public class ReservationSystem {
    private final Map<String, List<Reservation>> reservedBookings;
    private final IReservationLockProvider provider;
    public ReservationSystem(ReservationLockProvider provider){
        this.reservedBookings = new HashMap<>();
        this.provider = provider;
    }
    public List<String> roomsBooked(String hotelId, Date startDate, Date endDate){
        List<Reservation> reservations = reservedBookings.getOrDefault(hotelId,new ArrayList<>());
        reservations.addAll(provider.getLockedReservations(hotelId));
        List<String> roomIdsBooked = new ArrayList<>();
        for(Reservation reservation : reservations){
            if(reservation.exists(startDate,endDate)){
                roomIdsBooked.add(reservation.getRoomId());
            }
        }
        return roomIdsBooked;
    }
    public void printReservedBookings(){
        System.out.println(reservedBookings.values());
    }
    public void bookRooms(String hotelId, List<String> roomIds, Date startDate, Date endDate, User user) throws InterruptedException{
        provider.lockReservation(hotelId,roomIds,startDate,endDate,user);
        Thread.sleep(1000);
        for(String roomId : roomIds){
            Reservation newReservation = new Reservation(roomId,startDate,endDate);
            List<Reservation> reservations = reservedBookings.getOrDefault(hotelId,new ArrayList<>());
            reservations.add(newReservation);
            reservedBookings.put(hotelId,reservations);
        }
        provider.unlockReservation(hotelId,roomIds,startDate,endDate,user);
    }
}
