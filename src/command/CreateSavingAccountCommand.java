package command;

import service.BankService;

public class CreateSavingAccountCommand extends Command{
    public CreateSavingAccountCommand(BankService bankService) {
        super(bankService);
    }

    @Override
    public void execute() {
        bankService.createSavingAccount();
    }
}
