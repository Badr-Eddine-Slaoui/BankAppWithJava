package entity;

import exeption.InvalidAmount;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Operation {

    private final UUID uuid = UUID.randomUUID();
    private final LocalDateTime date = LocalDateTime.now();
    private double amount;

    public Operation(double amount){
        this.amount = amount;
    }

    public UUID getUuid(){
        return uuid;
    }

    public LocalDateTime getDate(){
        return date;
    }

    public double getAmount(){
        return amount;
    }

    public void setAmount(double amount) throws InvalidAmount {
        if (amount > 0 ) this.amount = amount;
        throw new InvalidAmount("Amount must be positive");
    }

}
