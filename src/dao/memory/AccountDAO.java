package dao.memory;

import entity.*;
import mapper.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDAO {
    private final Map<String, Account> accounts;

    public AccountDAO() {
        this.accounts = new HashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getCode(), account);
    }

    public Account getAccount(String code) {
        return accounts.get(code);
    }

    public List<Operation> getOperations(String code) {
        return accounts.get(code).getOperationsList();
    }
}
