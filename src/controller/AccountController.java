package controller;

import command.*;
import dto.CurrentAccountDTO;
import dto.SavingAccountDTO;
import service.BankService;

public class AccountController extends Controller{

    public AccountController(BankService bankService) {
        super(bankService);
    }

    public void createCurrentAccount(String name, double balance){
        CurrentAccountDTO accountDTO = new CurrentAccountDTO();
        accountDTO.setUserName(name);
        accountDTO.setBalance(balance);
        new CreateCurrentAccountCommand(bankService, accountDTO).execute();
    }

    public void createSavingAccount(String name, double balance){
        SavingAccountDTO accountDTO = new SavingAccountDTO();
        accountDTO.setUserName(name);
        accountDTO.setBalance(balance);
        new CreateSavingAccountCommand(bankService, accountDTO).execute();
    }

    public void displayBalance(String code){
        new DisplayBalanceCommand(bankService, code).execute();
    }

    public void displayOperations(String code){
        new DisplayOperationsCommand(bankService, code).execute();
    }

    public void displayAccount(String code){
        new DisplayAccountCommand(bankService, code).execute();
    }
}
