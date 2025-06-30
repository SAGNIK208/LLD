package com.lld.hotelbooking.services;

import com.lld.hotelbooking.models.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ReservationLockProvider implements IReservationLockProvider {

    private final Map<String,List<ReservationLock>> lockedReservationList;
    private long timeout;
    public ReservationLockProvider(long timeout) {
        this.lockedReservationList = new ConcurrentHashMap<>();
        this.timeout = timeout;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    @Override
    public void lockReservation(String hotelId,List<String> roomIds, Date startDate, Date endDate, User user){
        List<ReservationLock> reservationLocks= lockedReservationList.computeIfAbsent(hotelId,r ->  Collections.synchronizedList(new ArrayList<>()));
        synchronized (reservationLocks){
            for(String roomId : roomIds){
                Reservation newReservation = new Reservation(roomId,startDate,endDate);
                boolean isReservationLocked = reservationLocks.stream().anyMatch(r -> r.hasReservation(newReservation));
                if(isReservationLocked){
                    throw new RuntimeException("Room is already reserved");
                }
            }
            for(String roomId : roomIds){
                Reservation newReservation = new Reservation(roomId,startDate,endDate);
                ReservationLock reservationLock= new ReservationLock(newReservation,user,this.timeout);
                reservationLocks.add(reservationLock);
            }
        }
    }

    @Override
    public void unlockReservation(String hotelId,List<String> roomIds, Date startDate, Date endDate, User user) {
        List<ReservationLock> reservationLocks = lockedReservationList.get(hotelId);
        if(reservationLocks == null){
            return;
        }
        synchronized (reservationLocks){
            for(String roomId : roomIds){
                Reservation oldReservation = new Reservation(roomId,startDate,endDate);
                Optional<ReservationLock> reservationLock = reservationLocks.stream().filter(r -> r.hasReservation(oldReservation)).findFirst();
                if(reservationLock.isPresent() && reservationLock.get().getLockedBy().equals(user)){
                    reservationLocks.remove(reservationLock.get());
                }
            }
        }
    }

    @Override
    public List<Reservation> getLockedReservations(String hotelId) {
        List<ReservationLock> reservationLocks = lockedReservationList.get(hotelId);
        if(reservationLocks == null){
            return Collections.emptyList();
        }
        return reservationLocks
                .stream()
                .map(ReservationLock::getReservation)
                .collect(Collectors.toList());
    }
}
