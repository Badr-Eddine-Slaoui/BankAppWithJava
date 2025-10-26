package mapper;

import dto.SavingAccountDTO;
import entity.SavingAccount;

public class SavingAccountMapper {
    public static SavingAccountDTO toDTO(SavingAccount savingAccount){
        SavingAccountDTO savingAccountDTO = new SavingAccountDTO();
        savingAccountDTO.setUserName(savingAccount.getUserName());
        savingAccountDTO.setBalance(savingAccount.getBalance());
        return savingAccountDTO;
    }

    public static SavingAccount toEntity(SavingAccountDTO savingAccountDTO){
        return new SavingAccount(savingAccountDTO.getUserName(), savingAccountDTO.getBalance());
    }
}
