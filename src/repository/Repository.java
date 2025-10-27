package repository;

import entity.Account;
import entity.Operation;

import java.util.List;
import java.util.Optional;

public interface Repository {
    void addAccount(Account account);

    Optional<Account> getAccount(String code);

    List<Operation> getOperations(String code);
}
