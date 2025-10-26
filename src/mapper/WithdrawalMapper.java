package mapper;

import dto.WithdrawalDTO;
import entity.Withdrawal;

public class WithdrawalMapper implements Mapper<WithdrawalDTO, Withdrawal>{
    @Override
    public WithdrawalDTO toDTO(Withdrawal withdrawal){
        WithdrawalDTO withdrawalDTO = new WithdrawalDTO();
        withdrawalDTO.setAmount(withdrawal.getAmount());
        withdrawalDTO.setDestination(withdrawal.getDestination());
        return withdrawalDTO;
    }
    @Override
    public Withdrawal toEntity(WithdrawalDTO withdrawalDTO){
        return new Withdrawal(withdrawalDTO.getAmount(), withdrawalDTO.getDestination());
    }
}
