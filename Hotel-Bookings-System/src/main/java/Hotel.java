package main.java;

import java.io.*;
import java.util.*;

public class Hotel implements Serializable
{
    private ArrayList<Room> rooms;
    private ArrayList<Costumer> costumers;
    private ArrayList<Room> availableRooms;

    public Hotel()
    {
        this.rooms = new ArrayList<Room>();
        //15 Class "C" rooms
        for(int i = 0; i < 15; i++){
            this.rooms.add(new ClassCRoom(i));
        }
        //10 Class "B" rooms
        for(int i = 15; i < 25; i++){
            this.rooms.add(new ClassBRoom(i));
        }
        //5 Class "A" rooms
        for(int i = 25; i < 30; i++){
            this.rooms.add(new ClassARoom(i));
        }
        this.costumers = new ArrayList<Costumer>();
    }

    public Iterator<Room> roomIterator()
    {
        return this.rooms.iterator();
    }
    public Iterator<Costumer> costumersIterator()
    {
        return this.costumers.iterator();
    }
    public void addCostumer(Costumer aCostumer)
    {
        this.costumers.add(aCostumer);
    }
    public void addRoom(Room aRoom)
    {
        this.rooms.add(aRoom);
    }

    public Costumer getCostumerById(int id)
    {
        Iterator<Costumer> it = costumersIterator();

        while(it.hasNext()) {
            Costumer costumer = it.next();
            if(costumer.getId() == id){
                return costumer;
            }
        }
        return null;
    }

    public void getAvailableRooms(Calendar startDate, Calendar endDate, int roomPrice)
    {
        Iterator<Room> it = roomIterator();
        this.availableRooms = new ArrayList<Room>();
        while(it.hasNext()) {
            Room room = it.next();
            if(room.getPrice() == roomPrice && room.isAvailable(startDate, endDate)) {
                this.availableRooms.add(room);
            }
        }
    }

    public void cancelReservation(Reservation aReservation)
    {
        Iterator<Room> it = roomIterator();
        while(it.hasNext()) {
            Room room = it.next();
            if(room.getRoomNumber() == aReservation.getRoomNumber()) {
                room.cancelReservation(aReservation.getReservationNumber());
                return;
            }
        }
    }

    public ArrayList<Reservation> getReservations(Costumer aCostumer)
    {
        Iterator<Room> it = roomIterator();
        ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
        while(it.hasNext()) {
            Room room = it.next();
            ArrayList<Reservation> reservations = room.getReservations();
            Iterator<Reservation> it1 = reservations.iterator();
            while(it1.hasNext()){
                if (it1.next().getCostumer().getId() == aCostumer.getId())
                reservationList.add(it1.next());
            }
        }
        return reservationList;
    }

    public ArrayList<Reservation> getReservations(Date aDate)
    {
        Iterator<Room> it = roomIterator();
        ArrayList<Reservation> reservesSameDate = new ArrayList<Reservation>();
        while(it.hasNext()) {
            Room room = it.next();
            ArrayList<Reservation> reservations = room.getReservations();
            for(Reservation re : reservations) {
                if(aDate.before(re.getStartDate()) || aDate.after(re.getEndDate())){
                    continue;
                }
                reservesSameDate.add(re);
            }
        }
        return reservesSameDate;
    }

    public ArrayList<Room> getRooms()
    {
        return this.rooms;
    }
}
