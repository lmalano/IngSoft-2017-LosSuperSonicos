package main.java;

/**
 * Business Room.
 * Class B
 */
public class ClassBRoom extends Room {

    public ClassBRoom(int aRoomNumber){
        super(aRoomNumber, 2, Boolean.TRUE);
        this.price = 100;
    }

    @Override
    public String description() {
        String aDescription = super.description();

        aDescription.concat("\n Class B room also has:\n Balcony - Bar");

        return aDescription;
    }
}