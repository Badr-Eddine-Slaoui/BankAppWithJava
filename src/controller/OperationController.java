package controller;

import command.MakeDepositCommand;
import command.MakeTransferCommand;
import command.MakeWithdrawalCommand;
import service.BankService;

public class OperationController extends Controller{
    public OperationController(BankService bankService) {
        super(bankService);
    }

    public void deposit(){
        new MakeDepositCommand(bankService).execute();
    }

    public void withdraw(){
        new MakeWithdrawalCommand(bankService).execute();
    }

    public void transfer(){
        new MakeTransferCommand(bankService).execute();
    }
}
