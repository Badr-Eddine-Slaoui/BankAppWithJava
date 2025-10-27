package repository.db;

import dao.db.AccountDAO;
import entity.*;
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
    public void deposit(Account account, Deposit deposit) {
        accountDAO.deposit(account, deposit);
    }

    @Override
    public void withdraw(Account account, Withdrawal withdrawal) {
        accountDAO.withdraw(account, withdrawal);
    }

    @Override
    public void transfer(Account senderAccount, Account receiverAccount, Transfer transfer) {
        accountDAO.transfer(senderAccount, receiverAccount, transfer);
    }

    @Override
    public List<Operation> getOperations(String code) {
        return accountDAO.getOperations(code);
    }

}
