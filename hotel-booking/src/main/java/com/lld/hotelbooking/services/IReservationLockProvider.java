package com.lld.hotelbooking.services;

import com.lld.hotelbooking.models.Reservation;
import com.lld.hotelbooking.models.User;

import java.util.Date;
import java.util.List;

public interface IReservationLockProvider {
    void lockReservation(String hotelId, List<String> roomIds, Date startDate, Date endDate, User user);
    void unlockReservation(String hotelId,List<String> roomIds, Date startDate, Date endDate, User user);
    List<Reservation> getLockedReservations(String hotelId);
}
