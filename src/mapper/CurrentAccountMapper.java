package mapper;

import dto.CurrentAccountDTO;
import entity.CurrentAccount;
import entity.Deposit;
import entity.Transfer;
import entity.Withdrawal;

import java.util.Objects;
import java.util.stream.Collectors;

public class CurrentAccountMapper implements Mapper<CurrentAccountDTO, CurrentAccount>{
    @Override
    public CurrentAccountDTO toDTO(CurrentAccount currentAccount){
        CurrentAccountDTO currentAccountDTO = new CurrentAccountDTO();
        currentAccountDTO.setUserName(currentAccount.getUserName());
        currentAccountDTO.setBalance(currentAccount.getBalance());
        currentAccountDTO.setOperationsList(currentAccount
                .getOperationsList()
                .stream()
                .map(operation -> {
                    return operation instanceof Deposit ? new DepositMapper().toDTO((Deposit) operation)
                            : operation instanceof Withdrawal ? new WithdrawalMapper().toDTO((Withdrawal) operation)
                            : operation instanceof Transfer ? new TransferMapper().toDTO((Transfer) operation)
                            : null;
                }).filter(Objects::nonNull)
                .collect(Collectors.toList()));
        return currentAccountDTO;
    }

    @Override
    public CurrentAccount toEntity(CurrentAccountDTO currentAccountDTO){
        return new CurrentAccount(currentAccountDTO.getUserName(),currentAccountDTO.getBalance());
    }
}
