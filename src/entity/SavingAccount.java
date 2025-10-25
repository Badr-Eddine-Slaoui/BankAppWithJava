package entity;

import exeption.InsufficientBalanceException;
import exeption.InvalidAmount;

public class SavingAccount extends Account{
    private static final double interestRate = 0.05;

    public SavingAccount(String username, double balance){
        super(username, balance);
    }

    public double getInterestRate(){
        return interestRate;
    }

    @Override
    public void withdraw(double amount) throws InvalidAmount, InsufficientBalanceException {
        if (amount <= 0 ) throw new InvalidAmount("Amount must be positive");
        if (getBalance() - amount < 0 ) throw new InsufficientBalanceException("Insufficient balance");
        setBalance(getBalance() - amount);
    }

    @Override
    public double calculateIntrest(){
        return getBalance() * interestRate;
    }
}
