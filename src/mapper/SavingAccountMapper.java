package mapper;

import dto.SavingAccountDTO;
import entity.SavingAccount;

public class SavingAccountMapper implements Mapper<SavingAccountDTO, SavingAccount>{
    @Override
    public SavingAccountDTO toDTO(SavingAccount savingAccount){
        SavingAccountDTO savingAccountDTO = new SavingAccountDTO();
        savingAccountDTO.setUserName(savingAccount.getUserName());
        savingAccountDTO.setBalance(savingAccount.getBalance());
        return savingAccountDTO;
    }

    @Override
    public SavingAccount toEntity(SavingAccountDTO savingAccountDTO){
        return new SavingAccount(savingAccountDTO.getUserName(), savingAccountDTO.getBalance());
    }
}
