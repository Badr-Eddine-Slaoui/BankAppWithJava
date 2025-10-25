package ui;

import service.BankService;

public abstract class UI {
    public BankService bankService;

    public UI(BankService bankService){
        this.bankService = bankService;
    }

    abstract public void start();
    abstract public void showMenu();
}
