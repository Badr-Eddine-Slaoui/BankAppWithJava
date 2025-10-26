package command;

import service.BankService;

public class MakeWithdrawalCommand extends Command{
    public MakeWithdrawalCommand(BankService bankService) {
        super(bankService);
    }

    @Override
    public void execute() {
        bankService.withdraw();
    }
}
