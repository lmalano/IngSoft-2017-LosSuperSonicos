package main.java;

/**
 * Created by narc2 on 25/06/2017.
 */
public class Costumer {
    private int Id;
    private String name;
    private String lastName;
    private int creditCardNumber;

    public void setCostumerId(int aCostumerId)
    {
        this.Id = aCostumerId;
    }
    public void setCostumerName(String aName)
    {
        this.name = aName;
    }
    public void setLastName(String aLastName)
    {
        this.lastName = aLastName;
    }
    public void setCreditCardNumber(int creditCardNumber)
    {
        this.creditCardNumber = creditCardNumber;
    }

    public int getId()
    {
        return this.Id;
    }
    public String getName() {
        return this.name;
    }
    public String getLastName() {
        return this.lastName;
    }
    public int getCreditCardNumber() {
        return this.creditCardNumber;
    }
}
