package ui;

import controller.OperationController;
import enums.DestinationEnum;
import exeption.InvalidDestinationException;
import util.HandleInput;
import util.ValidatInput;

public class WithdrawUI implements UI{

    private final OperationController controller;

    public WithdrawUI(OperationController controller){
        this.controller = controller;
    }

    @Override
    public void start() throws InvalidDestinationException {
        try {
            int choice;
            showMenu();
            choice = HandleInput.getInt("Enter your choice: ");

            DestinationEnum destination = null;

            switch (choice){
                case 1 : {
                    destination = DestinationEnum.ATM;
                }
                case 2 : {
                    destination = DestinationEnum.CHECK;
                }
                case 3 : {
                    destination = DestinationEnum.OUTGOING_TRANSFER;
                }
                case 4 : {
                    break;
                }
                default: {
                    throw new InvalidDestinationException("Invalid Destination!");
                }
            }

            String code = HandleInput.getString("Enter the account code: ");
            ValidatInput.isValidCode(code);

            double amount = HandleInput.getDouble("Enter the amount: ");
            ValidatInput.isValidAmount(amount);

            controller.withdraw(code, amount, destination);
        }catch (Exception e){
            System.err.println("Unexpected Error : " + e.getMessage());
        }
    }

    @Override
    public void showMenu(){
        System.out.println("1. ATM Withdraw");
        System.out.println("2. Check Withdraw");
        System.out.println("3. Outgoing Transfer Withdraw");
        System.out.println("4. Back To Main Menu");
    }

}