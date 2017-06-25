package main.java;

/**
 * Average Room.
 * Class C
 */
public class ClassCRoom extends Room {

    public ClassCRoom(int aRoomNumber){
        super(aRoomNumber, 1, Boolean.FALSE);
        this.price = 50;
    }

    @Override
    public String description() {
        String aDescription = super.description();

        aDescription.concat("\n Class C room also has:\n Bar");

        return aDescription;
    }
}