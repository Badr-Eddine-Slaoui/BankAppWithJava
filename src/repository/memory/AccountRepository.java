package repository.memory;

import dao.memory.AccountDAO;
import entity.Account;

import java.util.Optional;

public class AccountRepository {
    private final AccountDAO accountDAO;

    public AccountRepository() {
        this.accountDAO = new AccountDAO();
    }

    public void addAccount(Account account) {
        accountDAO.addAccount(account);
    }

    public Optional<Account> getAccount(String code) {
        return accountDAO.getAccount(code);
    }
}
