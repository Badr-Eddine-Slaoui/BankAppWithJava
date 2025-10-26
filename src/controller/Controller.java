package controller;

import service.BankService;

public class Controller {
    public BankService bankService;

    public Controller(BankService bankService){
        this.bankService = bankService;
    }
}
