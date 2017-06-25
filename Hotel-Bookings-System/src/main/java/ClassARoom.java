package main.java;

/**
 * Premium Room.
 * Class A
 */
public class ClassARoom extends Room {

    public ClassARoom(int aRoomNumber){
        super(aRoomNumber, 4, Boolean.TRUE);
        this.price = 200;
    }

    @Override
    public String description() {
        String aDescription = super.description();

        aDescription.concat("\n Class A room also has:\n Jacuzzi - Balcony - Bar - Pool");

        return aDescription;
    }
}
