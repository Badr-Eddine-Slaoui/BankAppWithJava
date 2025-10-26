package ui;


import controller.AccountController;
import util.HandleInput;
import util.ValidatInput;

public class DisplayAccountUI implements UI {

    private final AccountController controller;

    public DisplayAccountUI(AccountController controller){
        this.controller = controller;
    }

    @Override
    public void start() {
        try {
            String code = HandleInput.getString("Enter the account code: ");
            ValidatInput.isValidCode(code);

            controller.displayAccount(code);
        } catch (Exception e) {
            System.out.println("Unexpected Error : " + e.getMessage());
        }
    }

    @Override
    public void showMenu() {}
}
