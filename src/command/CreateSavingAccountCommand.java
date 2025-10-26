package command;

import dto.SavingAccountDTO;
import service.BankService;

public class CreateSavingAccountCommand extends Command{
    private final SavingAccountDTO accountDTO;

    public CreateSavingAccountCommand(BankService bankService, SavingAccountDTO accountDTO) {
        super(bankService);
        this.accountDTO = accountDTO;
    }

    @Override
    public void execute() {
        bankService.createSavingAccount(this.accountDTO);
    }
}
