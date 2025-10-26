package command;

import dto.AccountDTO;
import dto.CurrentAccountDTO;
import service.BankService;

public class CreateCurrentAccountCommand extends Command{
    private final CurrentAccountDTO accountDTO;
    public CreateCurrentAccountCommand(BankService bankService, CurrentAccountDTO accountDTO) {
        super(bankService);
        this.accountDTO = accountDTO;
    }

    @Override
    public void execute() {
        bankService.createCurrentAccount(this.accountDTO);
    }
}
