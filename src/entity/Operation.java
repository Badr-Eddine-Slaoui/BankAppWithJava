package entity;

import exeption.InvalidAmountException;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Operation implements Serializable {

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

    public void setAmount(double amount) throws InvalidAmountException {
        if (amount > 0 ) this.amount = amount;
        throw new InvalidAmountException("Amount must be positive");
    }

}
