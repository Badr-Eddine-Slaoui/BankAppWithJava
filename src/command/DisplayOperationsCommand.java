package command;

import service.BankService;

public class DisplayOperationsCommand extends Command{
    public DisplayOperationsCommand(BankService bankService) {
        super(bankService);
    }

    @Override
    public void execute() {
        bankService.displayOperations();
    }
}
