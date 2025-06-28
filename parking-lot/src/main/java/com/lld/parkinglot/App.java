package com.lld.parkinglot;

import com.lld.parkinglot.Parking.ParkingFloor;
import com.lld.parkinglot.Parking.ParkingSpot;
import com.lld.parkinglot.Parking.ParkingSpotType;
import com.lld.parkinglot.Payment.BasicPaymentStrategy;
import com.lld.parkinglot.Payment.UPIPayment;
import com.lld.parkinglot.Ticket.Ticket;
import com.lld.parkinglot.Ticket.TicketManager;
import com.lld.parkinglot.Vehicle.CarVehicle;
import com.lld.parkinglot.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "Hello World!" );
        List<ParkingFloor> parkingFloorList = new ArrayList<ParkingFloor>();
        List<ParkingSpot> parkingSpotList = new ArrayList<ParkingSpot>();
        parkingSpotList.add(new ParkingSpot( ParkingSpotType.COMPACT));
        parkingSpotList.add(new ParkingSpot( ParkingSpotType.LARGE));
        parkingSpotList.add(new ParkingSpot( ParkingSpotType.TWO_WHEELER));
        parkingFloorList.add(new ParkingFloor(0,parkingSpotList));
        parkingFloorList.add(new ParkingFloor(1,parkingSpotList));
        parkingFloorList.add(new ParkingFloor(2,parkingSpotList));
        TicketManager ticketManager = new TicketManager();
        ParkingLot parkingLot = ParkingLot.getInstance(parkingFloorList,ticketManager);
        Vehicle vehicle = new CarVehicle();
        Ticket ticket = parkingLot.entry(vehicle,ParkingSpotType.COMPACT,new BasicPaymentStrategy());
        Thread.sleep(5000);
        boolean isSuccess = parkingLot.exit(ticket,new UPIPayment());
        System.out.println(isSuccess);
    }
}
