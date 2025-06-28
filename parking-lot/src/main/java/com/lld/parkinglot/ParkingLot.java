package com.lld.parkinglot;

import com.lld.parkinglot.Parking.ParkingFloor;
import com.lld.parkinglot.Parking.ParkingSpot;
import com.lld.parkinglot.Parking.ParkingSpotType;
import com.lld.parkinglot.Payment.PaymentMethod;
import com.lld.parkinglot.Payment.PaymentProcessor;
import com.lld.parkinglot.Payment.PaymentStrategy;
import com.lld.parkinglot.Ticket.Ticket;
import com.lld.parkinglot.Ticket.TicketManager;
import com.lld.parkinglot.Vehicle.Vehicle;

import java.util.List;
import java.util.UUID;

public class ParkingLot {
    private final String ID;
    private final List<ParkingFloor> ParkingFloorList;
    private static ParkingLot INSTANCE;
    private final TicketManager ticketManager;

    private ParkingLot(List<ParkingFloor> ParkingFloorList,TicketManager ticketManager){
        ID = UUID.randomUUID().toString();
        this.ParkingFloorList = ParkingFloorList;
        this.ticketManager = ticketManager;
    }

    public static  ParkingLot getInstance(List<ParkingFloor> ParkingFloorList,TicketManager ticketManager){
        if(INSTANCE == null){
            INSTANCE = new ParkingLot(ParkingFloorList,ticketManager);
        }
        return INSTANCE;
    }

    public void addNewFloor(ParkingFloor parkingFloor){
        this.ParkingFloorList.add(parkingFloor);
    }

    public boolean isFull(ParkingSpotType parkingSpotType){
        return allocateSpot(parkingSpotType) == null;
    }

    public ParkingSpot allocateSpot(ParkingSpotType parkingSpotType){
        for(ParkingFloor parkingFloor : ParkingFloorList){
            ParkingSpot parkingSpot = parkingFloor.findFreeParkingSpot(parkingSpotType);
            if(parkingSpot != null) return parkingSpot;
        }
        return null;
    }

    public Ticket entry(Vehicle vehicle, ParkingSpotType type, PaymentStrategy paymentStrategy){
        ParkingSpot parkingSpot = allocateSpot(type);
        if(parkingSpot != null){
            parkingSpot.occupy(vehicle);
            return  ticketManager.provideTicket(parkingSpot,paymentStrategy);
        }
        return null;
    }

    public boolean exit(Ticket ticket, PaymentMethod paymentMethod){
        ticket.updateExitTime();
        boolean isSuccess = PaymentProcessor.processPayment(ticket,paymentMethod);
        if(isSuccess){
            ticketManager.closeTicket(ticket.getID());
        }
        return true;
    }
}
