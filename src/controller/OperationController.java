package controller;

import command.MakeDepositCommand;
import command.MakeTransferCommand;
import command.MakeWithdrawalCommand;
import dto.DepositDTO;
import dto.WithdrawalDTO;
import enums.DestinationEnum;
import enums.SourceEnum;
import service.BankService;

public class OperationController extends Controller{
    public OperationController(BankService bankService) {
        super(bankService);
    }

    public void deposit(String code, double amount, SourceEnum source){
        DepositDTO depositDTO = new DepositDTO();
        depositDTO.setAmount(amount);
        depositDTO.setSource(source);
        new MakeDepositCommand(bankService, code, depositDTO).execute();
    }

    public void withdraw(String code, double amount, DestinationEnum destination){
        WithdrawalDTO withdrawalDTO = new WithdrawalDTO();
        withdrawalDTO.setAmount(amount);
        withdrawalDTO.setDestination(destination);
        new MakeWithdrawalCommand(bankService, code, withdrawalDTO).execute();
    }

    public void transfer(String senderCode, String receiverCode, double amount){
        new MakeTransferCommand(bankService, senderCode, receiverCode, amount).execute();
    }
}
