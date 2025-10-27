package repository.file;

import dao.file.AccountDAO;
import entity.Account;
import entity.Operation;
import repository.Repository;

import java.util.List;
import java.util.Optional;

public class AccountRepository implements Repository {
    private final AccountDAO accountDAO;

    public AccountRepository() {
        this.accountDAO = new AccountDAO();
    }

    @Override
    public void addAccount(Account account) {
        accountDAO.addAccount(account);
    }

    @Override
    public Optional<Account> getAccount(String code) {
        return accountDAO.getAccount(code);
    }

    @Override
    public List<Operation> getOperations(String code) {
        return accountDAO.getOperations(code);
    }
}