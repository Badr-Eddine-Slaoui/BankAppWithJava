package ui;

import controller.AccountController;
import util.HandleInput;
import util.ValidatInput;

public class CreateAccountUI implements UI{
    private final AccountController controller;

    public CreateAccountUI(AccountController controller){
        this.controller = controller;
    }

    @Override
    public void start(){
        try {
            int choice;
            showMenu();
            choice = HandleInput.getInt("Enter your choice: ");

            switch (choice){
                case 1 : {
                    String name = HandleInput.getString("Enter your name: ");
                    ValidatInput.isValidName(name);
                    double balance = HandleInput.getDouble("Enter your balance: ");

                    controller.createCurrentAccount(name, balance);
                    break;
                }
                case 2 : {
                    String name = HandleInput.getString("Enter your name: ");
                    ValidatInput.isValidName(name);
                    double balance = HandleInput.getDouble("Enter your balance: ");

                    controller.createSavingAccount(name, balance);
                    break;
                }
                case 3 : {
                    break;
                }
                default : {
                    System.out.println("Invalid Choice!");
                }
            }
        }catch (Exception e){
            System.err.println("Unexpected Error : " + e.getMessage());
        }
    }

    @Override
    public void showMenu(){
        System.out.println("1. Create A Current Account");
        System.out.println("2. Create A Saving Account");
        System.out.println("3. Back To Main Menu");
    }

}
