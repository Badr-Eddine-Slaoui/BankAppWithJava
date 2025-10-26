package command;

import service.BankService;

public class MakeDepositCommand extends Command{
    public MakeDepositCommand(BankService bankService) {
        super(bankService);
    }

    @Override
    public void execute() {
        bankService.deposit();
    }
}
