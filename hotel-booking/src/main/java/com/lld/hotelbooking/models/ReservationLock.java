package com.lld.hotelbooking.models;

public class ReservationLock {
    private final Reservation reservation;
    private final User lockedBy;
    private final Long timeout;
    private final Long timestamp;

    public ReservationLock(Reservation reservation, User lockedBy, Long timeout) {
        this.reservation = reservation;
        this.lockedBy = lockedBy;
        this.timeout = timeout;
        this.timestamp = System.currentTimeMillis();
    }

    public boolean hasReservation(Reservation reservation){
        return this.reservation.exists(reservation.getRoomId(),reservation.getStartDate(),reservation.getEndDate());
    }

    public boolean isLockExpired(){
        return this.timestamp + this.timeout < System.currentTimeMillis();
    }

    public Reservation getReservation() {
        return reservation;
    }

    public User getLockedBy() {
        return lockedBy;
    }

    public Long getTimeout() {
        return timeout;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
