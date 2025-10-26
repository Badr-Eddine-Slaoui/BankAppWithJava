package mapper;

import dto.CurrentAccountDTO;
import entity.CurrentAccount;

public class CurrentAccountMapper implements Mapper<CurrentAccountDTO, CurrentAccount>{
    @Override
    public CurrentAccountDTO toDTO(CurrentAccount currentAccount){
        CurrentAccountDTO currentAccountDTO = new CurrentAccountDTO();
        currentAccountDTO.setUserName(currentAccount.getUserName());
        currentAccountDTO.setBalance(currentAccount.getBalance());
        return currentAccountDTO;
    }

    @Override
    public CurrentAccount toEntity(CurrentAccountDTO currentAccountDTO){
        return new CurrentAccount(currentAccountDTO.getUserName(),currentAccountDTO.getBalance());
    }
}
