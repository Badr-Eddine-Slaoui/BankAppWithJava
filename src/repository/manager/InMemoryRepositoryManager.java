package repository.manager;

import repository.memory.AccountRepository;

public class InMemoryRepositoryManager {
    private final AccountRepository accountRepository;

    public InMemoryRepositoryManager() {
        this.accountRepository = new AccountRepository();
    }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }
}
