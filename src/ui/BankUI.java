package ui;

import controller.AccountController;
import controller.OperationController;
import service.BankService;
import util.HandleInput;

import java.util.HashMap;
import java.util.Map;

public class BankUI implements UI{
    private final Map<Integer, UI> menus = new HashMap<>();
    private final AccountController accountController;
    private final OperationController operationController;

    public BankUI(BankService bankService){
        this.accountController = new AccountController(bankService);
        this.operationController = new OperationController(bankService);
        initMenus();
    }

    @Override
    public void start(){
        try {
            int choice;
            do {
                showMenu();
                choice = HandleInput.getInt("Enter your choice: ");
                if (choice > 8){
                    System.out.println("Invalid Choice!");
                    continue;
                }
                menus.get(choice).start();
            } while (choice != 8);
        } catch (Exception e) {
            System.err.println("Unexpected Error : " + e.getMessage());
        }
    }

    @Override
    public void showMenu(){
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Display Balance");
        System.out.println("6. Display Operations");
        System.out.println("7. Display Account");
        System.out.println("8. Exit");
    }

    private void initMenus(){
        menus.put(1, new CreateAccountUI(this.accountController));
        menus.put(2, new DepositUI(this.operationController));
        menus.put(3, new WithdrawUI(this.operationController));
        menus.put(4, new TransferUI(this.operationController));
        menus.put(5, new DisplayBalanceUI(this.accountController));
        menus.put(6, new DisplayOperationsUI(this.accountController));
        menus.put(7, new DisplayAccountUI(this.accountController));
        menus.put(8, new UI() {
            @Override
            public void start() {System.out.println("Goodbye 👋");}
            @Override
            public void showMenu() {}
        });
    }

}
