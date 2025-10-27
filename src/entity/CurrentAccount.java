package entity;

import exeption.InsufficientBalanceException;

public class CurrentAccount extends Account {
    private static final double overdraft = -300;

    public CurrentAccount(String username, double balance){
        super(username, balance);
    }

    public double getOverdraft(){
        return overdraft;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (getBalance() - amount < overdraft) throw new InsufficientBalanceException("Insufficient balance");
        setBalance(getBalance() - amount);
    }

    @Override
    public double calculateIntrest(){
        return 0;
    }

}
