package mapper;

import dto.DepositDTO;
import entity.Deposit;

public class DepositMapper implements Mapper<DepositDTO, Deposit>{
    @Override
    public DepositDTO toDTO(Deposit deposit){
        DepositDTO depositDTO = new DepositDTO();
        depositDTO.setAmount(deposit.getAmount());
        depositDTO.setSource(deposit.getSource());
        return depositDTO;
    }
    @Override
    public Deposit toEntity(DepositDTO depositDTO){
        return new Deposit(depositDTO.getAmount(), depositDTO.getSource());
    }
}
