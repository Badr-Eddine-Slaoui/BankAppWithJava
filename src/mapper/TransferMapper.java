package mapper;

import dto.TransferDTO;
import entity.Transfer;

public class TransferMapper implements Mapper<TransferDTO, Transfer>{
    @Override
    public TransferDTO toDTO(Transfer transfer){
        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setSenderCode(transfer.getSenderCode());
        transferDTO.setReceiverCode(transfer.getReceiverCode());
        transferDTO.setAmount(transfer.getAmount());
        return transferDTO;
    }
    @Override
    public Transfer toEntity(TransferDTO transferDTO){
        return new Transfer(transferDTO.getAmount(), transferDTO.getSenderCode(), transferDTO.getReceiverCode());
    }
}
