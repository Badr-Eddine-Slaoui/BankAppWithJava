package ui;

import service.BankService;

public class BankUI extends UI{

    public BankUI(BankService bankService){
        super(bankService);
    }

    @Override
    public void start(){
        this.showMenu();
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

}
