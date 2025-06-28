package com.lld.parkinglot.Ticket;

import com.lld.parkinglot.Parking.ParkingSpot;
import com.lld.parkinglot.Payment.PaymentStrategy;

import java.util.HashMap;
import java.util.Map;

public class TicketManager {

    Map<String,ParkingSpot> activeParkingList;

    public TicketManager(){
        this.activeParkingList = new HashMap<String,ParkingSpot>();
    }

    public Ticket provideTicket(ParkingSpot parkingSpot, PaymentStrategy paymentStrategy){
        Ticket ticket = new Ticket(parkingSpot,paymentStrategy);
        activeParkingList.put(ticket.getID(),parkingSpot);
        return ticket;
    }

    public void closeTicket(String ticketId){
        ParkingSpot spot = activeParkingList.remove(ticketId);
        if (spot != null) {
            spot.unOccupy(); // you'd need to add this method
        }
        activeParkingList.remove(ticketId);
    }
}
