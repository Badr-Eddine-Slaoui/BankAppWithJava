package repository.manager;

import repository.memory.AccountRepository;

public class InMemoryRepositoryManager implements RepositoryManager {
    private final AccountRepository accountRepository;

    public InMemoryRepositoryManager() {
        this.accountRepository = new AccountRepository();
    }

    @Override
    public AccountRepository getAccountRepository() {
        return accountRepository;
    }
}
