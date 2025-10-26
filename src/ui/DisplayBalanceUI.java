package ui;

import controller.AccountController;
import util.HandleInput;
import util.ValidatInput;

public class DisplayBalanceUI implements UI{

    private final AccountController controller;

    public DisplayBalanceUI(AccountController controller){
        this.controller = controller;
    }

    @Override
    public void start(){
        try {
            String code = HandleInput.getString("Enter the account code: ");
            ValidatInput.isValidCode(code);

            controller.displayBalance(code);
        } catch (Exception e) {
            System.out.println("Unexpected Error : " + e.getMessage());
        }
    }

    @Override
    public void showMenu(){}

}