package repository.manager;

import repository.memory.AccountRepository;

public interface RepositoryManager {
    AccountRepository getAccountRepository();
}
