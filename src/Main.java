import repository.manager.DBRepositoryManager;
import repository.manager.RepositoryManager;
import service.BankService;
import ui.BankUI;

public class Main {
    public static void main(String[] args) {
        RepositoryManager repositoryManager = new DBRepositoryManager();
        BankService bankService = new BankService(repositoryManager);
        BankUI bankUI = new BankUI(bankService);

        bankUI.start();
    }
}