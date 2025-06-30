package com.lld.hotelbooking.models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Reservation {
    private final String roomId;
    private final Date startDate;
    private final Date endDate;
    public Reservation(String roomId,Date startDate,Date endDate){
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getRoomId() {
        return roomId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean exists(Date startDate,Date endDate){
        return !((this.startDate.after(endDate)) || (this.endDate.before(startDate)));
    }

    public boolean exists(String roomId,Date startDate,Date endDate){
        return this.roomId.equals(roomId) && exists(startDate,endDate);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "roomId='" + roomId + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
