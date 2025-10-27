package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public abstract class Account implements Serializable {
    private final String code = "CPT-" + String.format("%05d", new Random().nextInt(99999) + 1);
    private String userName;
    private double balance;
    private final List<Operation> operationsList;

    public Account(String userName, double balance) {
        this.userName = userName;
        this.balance = balance;
        this.operationsList = new ArrayList<Operation>();
    }

    public String getCode() {
        return code;
    }

    public String getUserName() {
        return userName;
    }

    public double getBalance() {
        return balance;
    }

    public List<Operation> getOperationsList() {
        return operationsList;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setOperationsList(Operation operation) {
        this.operationsList.add(operation);
    }

    abstract public void withdraw(double amount);

    abstract public double calculateIntrest();

    public void deposit(double amount){
        setBalance(getBalance() + amount);
    }

}
