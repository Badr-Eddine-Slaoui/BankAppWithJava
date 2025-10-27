package dao.memory;

import entity.*;
import mapper.*;

import java.util.*;

public class AccountDAO {
    private final Map<String, Account> accounts;

    public AccountDAO() {
        this.accounts = new HashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getCode(), account);
    }

    public Optional<Account> getAccount(String code) {
        return Optional.ofNullable(accounts.get(code));
    }

    public void deposit(Account account, Deposit deposit) {
        account.deposit(deposit.getAmount());
        account.setOperationsList(deposit);
    }

    public void withdraw(Account account, Withdrawal withdrawal) {
        account.withdraw(withdrawal.getAmount());
        account.setOperationsList(withdrawal);
    }

    public void transfer(Account senderAccount, Account receiverAccount, Transfer transfer) {
        senderAccount.withdraw(transfer.getAmount());
        receiverAccount.deposit(transfer.getAmount());

        senderAccount.setOperationsList(transfer);
        receiverAccount.setOperationsList(transfer);
    }

    public List<Operation> getOperations(String code) {
        Optional<Account> accountOptional = getAccount(code);
        if (accountOptional.isPresent()) {
            return accountOptional.get().getOperationsList();
        }
        return new ArrayList<>();
    }
}
