package command;

import dto.DepositDTO;
import service.BankService;

public class MakeDepositCommand extends Command{
    private final String code;
    private final DepositDTO depositDTO;

    public MakeDepositCommand(BankService bankService, String code, DepositDTO depositDTO) {
        super(bankService);
        this.code = code;
        this.depositDTO = depositDTO;
    }

    @Override
    public void execute() {
        bankService.deposit(this.code, this.depositDTO);
    }
}
