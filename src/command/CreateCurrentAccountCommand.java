package command;

import service.BankService;

public class CreateCurrentAccountCommand extends Command{
    public CreateCurrentAccountCommand(BankService bankService) {
        super(bankService);
    }

    @Override
    public void execute() {
        bankService.createCurrentAccount();
    }
}
