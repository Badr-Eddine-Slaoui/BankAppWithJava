package command;

import dto.DepositDTO;
import dto.WithdrawalDTO;
import service.BankService;

public class MakeWithdrawalCommand extends Command{
    private final String code;
    private final WithdrawalDTO withdrawalDTO;

    public MakeWithdrawalCommand(BankService bankService, String code, WithdrawalDTO withdrawalDTO) {
        super(bankService);
        this.code = code;
        this.withdrawalDTO = withdrawalDTO;
    }

    @Override
    public void execute() {
        bankService.withdraw(this.code, this.withdrawalDTO);
    }
}
