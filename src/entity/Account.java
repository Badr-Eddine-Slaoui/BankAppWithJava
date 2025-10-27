package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Account implements Serializable {
    private String code = "CPT-" + String.format("%05d", new Random().nextInt(99999) + 1);
    private final String userName;
    private double balance;
    private final List<Operation> operationsList;

    public Account(String userName, double balance) {
        this.userName = userName;
        this.balance = balance;
        this.operationsList = new ArrayList<>();
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserName() {
        return this.userName;
    }

    public double getBalance() {
        return this.balance;
    }

    public List<Operation> getOperationsList() {
        return this.operationsList;
    }

    /*public void setUserName(String userName) {
        this.userName = userName;
    }*/

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
