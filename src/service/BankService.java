package service;

import dao.memory.AccountDAO;
import dto.*;
import entity.*;
import exeption.AccountNotFoundException;
import mapper.*;
import repository.manager.RepositoryManager;

import java.util.Optional;

public class BankService {
    private final RepositoryManager repositoryManager;
    
    public BankService(RepositoryManager repositoryManager) {
        this.repositoryManager = repositoryManager;
    }
    
    public void createCurrentAccount(CurrentAccountDTO accountDTO){
        CurrentAccountMapper currentAccountMapper = new CurrentAccountMapper();
        CurrentAccount currentAccount = currentAccountMapper.toEntity(accountDTO);

        repositoryManager.getAccountRepository().addAccount(currentAccount);
        System.out.println("Current account created successfully");
    }

    public void createSavingAccount(SavingAccountDTO accountDTO){
        SavingAccountMapper savingAccountMapper = new SavingAccountMapper();
        SavingAccount savingAccount = savingAccountMapper.toEntity(accountDTO);

        repositoryManager.getAccountRepository().addAccount(savingAccount);
        System.out.println("Saving account created successfully");
    }

    public void deposit(String code, DepositDTO depositDTO) throws AccountNotFoundException{
        Optional<Account> accountOptional = repositoryManager.getAccountRepository().getAccount(code);
        accountOptional.orElseThrow(() -> new AccountNotFoundException("Account not found"));
        Account account = accountOptional.get();

        Deposit deposit = new DepositMapper().toEntity(depositDTO);
        account.deposit(deposit.getAmount());

        account.setOperationsList(deposit);
        System.out.println("Deposit made successfully");
    }

    public void withdraw(String code, WithdrawalDTO withdrawalDTO) throws AccountNotFoundException{
        Optional<Account> accountOptional = repositoryManager.getAccountRepository().getAccount(code);
        accountOptional.orElseThrow(() -> new AccountNotFoundException("Account not found"));
        Account account = accountOptional.get();

        Withdrawal withdrawal = new WithdrawalMapper().toEntity(withdrawalDTO);
        account.withdraw(withdrawal.getAmount());

        account.setOperationsList(withdrawal);
        System.out.println("Withdrawal made successfully");
    }

    public void transfer(TransferDTO transferDTO) throws AccountNotFoundException{
        Optional<Account> senderAccountOptional = repositoryManager.getAccountRepository().getAccount(transferDTO.getSenderCode());
        senderAccountOptional.orElseThrow(() -> new AccountNotFoundException("Sender account not found"));
        Account senderAccount = senderAccountOptional.get();

        Optional<Account> receiverAccountOptional = repositoryManager.getAccountRepository().getAccount(transferDTO.getReceiverCode());
        receiverAccountOptional.orElseThrow(() -> new AccountNotFoundException("Receiver account not found"));
        Account receiverAccount = receiverAccountOptional.get();

        Transfer transfer = new TransferMapper().toEntity(transferDTO);
        senderAccount.withdraw(transfer.getAmount());
        receiverAccount.deposit(transfer.getAmount());

        senderAccount.setOperationsList(transfer);
        receiverAccount.setOperationsList(transfer);
        System.out.println("Transfer made successfully");
    }

    public void displayBalance(String code) throws AccountNotFoundException{
        Optional<Account> accountOptional = repositoryManager.getAccountRepository().getAccount(code);
        accountOptional.orElseThrow(() -> new AccountNotFoundException("Account not found"));

        AccountDTO account = (accountOptional.get() instanceof CurrentAccount) ? new CurrentAccountMapper().toDTO((CurrentAccount) accountOptional.get())
                : new SavingAccountMapper().toDTO((SavingAccount) accountOptional.get());

        System.out.println("Balance: " + account.getBalance());
    }

    public void displayOperations(String code) throws AccountNotFoundException{
        Optional<Account> accountOptional = repositoryManager.getAccountRepository().getAccount(code);
        accountOptional.orElseThrow(() -> new AccountNotFoundException("Account not found"));

        AccountDTO account = (accountOptional.get() instanceof CurrentAccount) ? new CurrentAccountMapper().toDTO((CurrentAccount) accountOptional.get())
                : new SavingAccountMapper().toDTO((SavingAccount) accountOptional.get());

        System.out.println("Operations: ");
        for (OperationDTO operation : account.getOperationsList()) {
            System.out.println(operation);
        }
    }

    public void displayAccount(String code) throws AccountNotFoundException{
        Optional<Account> accountOptional = repositoryManager.getAccountRepository().getAccount(code);
        accountOptional.orElseThrow(() -> new AccountNotFoundException("Account not found"));

        AccountDTO account = (accountOptional.get() instanceof CurrentAccount) ? new CurrentAccountMapper().toDTO((CurrentAccount) accountOptional.get())
                : new SavingAccountMapper().toDTO((SavingAccount) accountOptional.get());

        account.displayDetails();
    }
}
