package command;

import dto.TransferDTO;
import service.BankService;

public class MakeTransferCommand extends Command{
    private final String senderCode;
    private final String receiverCode;
    private final double amount;

    public MakeTransferCommand(BankService bankService, String senderCode, String receiverCode, double amount) {
        super(bankService);
        this.senderCode = senderCode;
        this.receiverCode = receiverCode;
        this.amount = amount;
    }

    @Override
    public void execute() {
        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setSenderCode(senderCode);
        transferDTO.setReceiverCode(receiverCode);
        transferDTO.setAmount(amount);
        bankService.transfer(transferDTO);
    }
}
