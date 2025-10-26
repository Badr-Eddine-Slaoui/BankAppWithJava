package dao.memory;

import entity.*;
import mapper.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
}
