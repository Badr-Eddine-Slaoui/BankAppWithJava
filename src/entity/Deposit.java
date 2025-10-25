package entity;

import enums.SourceEnum;

public class Deposit extends Operation{
    private final SourceEnum source;

    public Deposit(double amount, SourceEnum source){
        super(amount);
        this.source = source;
    }

    public SourceEnum getSource(){
        return this.source;
    }
}
