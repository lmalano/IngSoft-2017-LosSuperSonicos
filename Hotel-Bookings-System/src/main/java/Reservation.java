package main.java;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation implements Serializable
{
    private Date startDate;
    private Date endDate;
    private int reservationNumber;
    private Room room;
    private Costumer costumer;
    private final SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(int aReservationNumber, Date aStartDate, Date aEndDate, Room aRoom, Costumer aCostumer)
    {
        this.reservationNumber = aReservationNumber;
        this.startDate = aStartDate;
        this.endDate = aEndDate;
        this.room = aRoom;
        this.costumer = aCostumer;
    }

    public Costumer getCostumer()
    {
        return this.costumer;
    }
    public int getReservationNumber()
    {
        return this.reservationNumber;
    }
    public int getRoomNumber()
    {
        return this.room.getRoomNumber();
    }
    public Date getStartDate()
    {
        return this.startDate;
    }
    public Date getEndDate()
    {
        return this.endDate;
    }
    public int getPrice()
    {
        long diff = this.endDate.getTime() - this.startDate.getTime();
        long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        return this.room.getPrice() * (int)days;
    }
    public String toString()
    {
        return "Room #" + getRoomNumber()
                + " checkin: " + this.date.format(this.startDate)
                + " checkout: " + this.date.format(this.endDate)
                + " - Price: " + this.getPrice();
    }
}

