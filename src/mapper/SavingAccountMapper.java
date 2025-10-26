package mapper;

import dto.SavingAccountDTO;
import entity.Deposit;
import entity.SavingAccount;
import entity.Transfer;
import entity.Withdrawal;

import java.util.Objects;
import java.util.stream.Collectors;

public class SavingAccountMapper implements Mapper<SavingAccountDTO, SavingAccount>{
    @Override
    public SavingAccountDTO toDTO(SavingAccount savingAccount){
        SavingAccountDTO savingAccountDTO = new SavingAccountDTO();
        savingAccountDTO.setUserName(savingAccount.getUserName());
        savingAccountDTO.setBalance(savingAccount.getBalance());
        savingAccountDTO.setOperationsList(savingAccount.getOperationsList()
                .stream()
                .map(operation -> {
                    return operation instanceof Deposit ? new DepositMapper().toDTO((Deposit) operation)
                            : operation instanceof Withdrawal ? new WithdrawalMapper().toDTO((Withdrawal) operation)
                            : operation instanceof Transfer ? new TransferMapper().toDTO((Transfer) operation)
                            : null;
                }).filter(Objects::nonNull)
                .collect(Collectors.toList()));
        return savingAccountDTO;
    }

    @Override
    public SavingAccount toEntity(SavingAccountDTO savingAccountDTO){
        return new SavingAccount(savingAccountDTO.getUserName(), savingAccountDTO.getBalance());
    }
}
