package command;

import service.BankService;

public class DisplayOperationsCommand extends Command{
    private final String code;

    public DisplayOperationsCommand(BankService bankService, String code) {
        super(bankService);
        this.code = code;
    }

    @Override
    public void execute() {
        bankService.displayOperations(code);
    }
}
