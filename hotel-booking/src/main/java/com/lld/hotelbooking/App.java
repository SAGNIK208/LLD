package com.lld.hotelbooking;

import com.lld.hotelbooking.models.*;
import com.lld.hotelbooking.services.HotelManagementSystem;
import com.lld.hotelbooking.services.ReservationLockProvider;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "Hello World!" );
        Location location = new Location("Dubai","UAE");
        Hotel hotel = new Hotel("JW Marriot",location);
        Map<String,Room> roomStore = new HashMap<>();
        Room room1 = new DeluxeRoom(hotel.getID());
        Room room2 = new DeluxeRoom(hotel.getID());
        roomStore.put(room1.getID(), room1);
        roomStore.put(room2.getID(), room2);
        hotel.setRooms(roomStore);
        User user = new BasicUser("Sg");
        HotelManagementSystem hotelManagementSystem = new HotelManagementSystem();
        hotelManagementSystem.addHotel(hotel);
        hotelManagementSystem.roomsAvailable(hotel.getID(),new Date(),addDays(new Date(),5));
        System.out.println(hotelManagementSystem.roomsAvailable(hotel.getID(),new Date(),addDays(new Date(),5)));
        List<String> bookRoom1 = new ArrayList<>();
        bookRoom1.add(room1.getID());
        Thread t1 = new Thread(()->{
           hotelManagementSystem.bookRooms(hotel.getID(),bookRoom1,new Date(),addDays(new Date(),5),user);
        });
        t1.setName("first booking");
        t1.start();
        Thread t2 = new Thread(()->{
           hotelManagementSystem.bookRooms(hotel.getID(),bookRoom1,new Date(),addDays(new Date(),15),user);
        });
        t2.setName("second booking");
        t2.start();
        Thread.sleep(3000);
        System.out.println(hotelManagementSystem.roomsAvailable(hotel.getID(),new Date(),addDays(new Date(),5)));
        t1.join();
    }

    public static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }
}
