package repository.manager;

import repository.db.AccountRepository;

public class DBRepositoryManager implements RepositoryManager {
    private final AccountRepository accountRepository;

    public DBRepositoryManager() {
        this.accountRepository = new AccountRepository();
    }

    @Override
    public AccountRepository getAccountRepository() {
        return accountRepository;
    }
}
