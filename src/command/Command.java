package command;

import service.BankService;

public abstract class Command {
    public BankService bankService;

    public Command(BankService bankService){
        this.bankService = bankService;
    }

    public abstract void execute();
}
