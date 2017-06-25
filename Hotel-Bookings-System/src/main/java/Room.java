package main.java;

import java.io.Serializable;
import java.util.*;

/**
 * Hotel room.
 */
public abstract class Room
{

    protected int roomNumber;
    protected int numberOfBeds;
    protected int price;
    protected Boolean wifi;
    private ArrayList<Reservation> reservationList;

    public Room(int aRoomNumber, int aNumberOfBeds, Boolean aHasWifi)
    {
        this.roomNumber = aRoomNumber;
        this.numberOfBeds = aNumberOfBeds;
        this.wifi = aHasWifi;
        this.reservationList = new ArrayList<Reservation>();
    }

    public void addReservation(Reservation aReservation)
    {
        this.reservationList.add(aReservation);
    }
    public void cancelReservation(int  aReservationNumber)
    {
        for (Reservation reservation : reservationList) {
            if (reservation.getReservationNumber() == aReservationNumber){
                reservationList.remove(reservation);
                break;
            }
        }
    }
    public boolean isAvailable(Calendar startDate, Calendar endDate)
    {
        Iterator<Reservation> it = reservationList.iterator();
        while(it.hasNext())
        {
            Reservation nextReservation = it.next();
            Date sDate = nextReservation.getStartDate();
            Date eDate = nextReservation.getEndDate();
            if( ((sDate.after(startDate.getTime()) || sDate.equals(startDate.getTime()))
                    && (sDate.before(endDate.getTime())) || sDate.equals(endDate.getTime()))
                    ||  ((eDate.after(startDate.getTime()) || eDate.equals(startDate.getTime()))
                    && (eDate.before(endDate.getTime()) || eDate.equals(endDate.getTime()))))
            {
                return false;
            }
        }

        return true;
    }

    public void setReservations(ArrayList<Reservation> aReservationList)
    {
        this.reservationList = aReservationList;
    }
    public void setRoomNumber(int aRoomNumber)
    {
        this.roomNumber = aRoomNumber;
    }
    public void setNumberOfBeds(int aNumberOfBeds)
    {
        this.numberOfBeds = aNumberOfBeds;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }
    public void setWifi(Boolean aHasWifi)
    {
        this.wifi = aHasWifi;
    }

    public ArrayList<Reservation> getReservations()
    {
        return this.reservationList;
    }
    public int getNumberOfBeds()
    {
        return this.numberOfBeds;
    }
    public int getRoomNumber()
    {
        return this.roomNumber;
    }
    public int getPrice()
    {
        return this.price;
    }
    public Boolean hasWifi()
    {
        return this.wifi;
    }
    protected String description()
    {
        String Description = "Room number: " + this.roomNumber
                            + "\nBeds: " + this.numberOfBeds
                            + "\nPrice: $" + this.price
                            + "\nWifi: ";
        if (this.wifi){
            Description.concat("Yes");
        }
        else{
            Description.concat("No");
        }

        return Description;
    }
}
