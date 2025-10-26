package command;

import service.BankService;

public class MakeTransferCommand extends Command{
    public MakeTransferCommand(BankService bankService) {
        super(bankService);
    }

    @Override
    public void execute() {
        bankService.transfer();
    }
}
