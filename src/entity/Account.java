package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public abstract class Account {
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
    public void displayDetails(){
        System.out.println("========================================");

        System.out.printf("| %-12s | %s%n", "Account", getCode());
        System.out.printf("| %-12s | %s%n", "Name", getUserName());
        if (this instanceof CurrentAccount) {
            System.out.printf("| %-12s | Current Account%n", "Type");
            System.out.printf("| %-12s | %.2f DH%n", "overdraft", ((CurrentAccount)this).getOverdraft());
        } else if (this instanceof SavingAccount) {
            System.out.printf("| %-12s | Saving Account%n", "Type");
            System.out.printf("| %-12s | %.2f %% %n", "interest rate", ((SavingAccount)this).getInterestRate() * 100);
        }
        System.out.printf("| %-12s | %.2f DH%n", "Balance", getBalance());
        System.out.println("========================================");
    };

}
