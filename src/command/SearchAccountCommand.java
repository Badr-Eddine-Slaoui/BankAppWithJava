package command;

import service.BankService;

public class SearchAccountCommand extends Command{
    public SearchAccountCommand(BankService bankService) {
        super(bankService);
    }

    @Override
    public void execute() {
        bankService.searchAccount();
    }
}
