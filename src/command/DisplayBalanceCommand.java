package command;

import service.BankService;

public class DisplayBalanceCommand extends Command{
    public DisplayBalanceCommand(BankService bankService) {
        super(bankService);
    }

    @Override
    public void execute() {
        bankService.displayBalance();
    }
}
