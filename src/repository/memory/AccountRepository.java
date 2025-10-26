package repository.memory;

import dao.memory.AccountDAO;
import entity.Account;
import entity.Operation;

import java.util.List;

public class AccountRepository {
    private final AccountDAO accountDAO;

    public AccountRepository() {
        this.accountDAO = new AccountDAO();
    }

    public void addAccount(Account account) {
        accountDAO.addAccount(account);
    }

    public Account getAccount(String code) {
        return accountDAO.getAccount(code);
    }

    public List<Operation> getOperations(String code) {
        return accountDAO.getOperations(code);
    }
}
