package repository;

import entity.*;

import java.util.List;
import java.util.Optional;

public interface Repository {
    void addAccount(Account account);

    Optional<Account> getAccount(String code);

    void deposit(Account account, Deposit deposit);

    void withdraw(Account account, Withdrawal withdrawal);

    void transfer(Account senderAccount, Account receiverAccount, Transfer transfer);

    List<Operation> getOperations(String code);
}
