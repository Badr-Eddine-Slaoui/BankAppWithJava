package repository.manager;

import repository.file.AccountRepository;

public class FileRepositoryManager implements RepositoryManager {
    private final AccountRepository accountRepository;

    public FileRepositoryManager() {
        this.accountRepository = new AccountRepository();
    }

    @Override
    public AccountRepository getAccountRepository() {
        return accountRepository;
    }
}
