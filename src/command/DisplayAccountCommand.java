package command;

import service.BankService;

public class DisplayAccountCommand extends Command{
    private final String code;

    public DisplayAccountCommand(BankService bankService, String code) {
        super(bankService);
        this.code = code;
    }

    @Override
    public void execute() {
        bankService.displayAccount(code);
    }
}
