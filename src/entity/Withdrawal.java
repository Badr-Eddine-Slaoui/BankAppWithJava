package entity;

import enums.DestinationEnum;

public class Withdrawal extends Operation{
    private final DestinationEnum destination;

    public Withdrawal(double amount, DestinationEnum destination){
        super(amount);
        this.destination = destination;
    }

    public DestinationEnum getDestination(){
        return this.destination;
    }
}
