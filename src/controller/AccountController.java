package controller;

import command.*;
import service.BankService;

public class AccountController extends Controller{

    public AccountController(BankService bankService) {
        super(bankService);
    }

    public void createCurrentAccount(){
        new CreateCurrentAccountCommand(bankService).execute();
    }

    public void createSavingAccount(){
        new CreateSavingAccountCommand(bankService).execute();
    }

    public void displayBalance(){
        new DisplayBalanceCommand(bankService).execute();
    }

    public void displayOperation(){
        new DisplayOperationsCommand(bankService).execute();
    }

    public void searchAccount(){
        new SearchAccountCommand(bankService).execute();
    }
}
