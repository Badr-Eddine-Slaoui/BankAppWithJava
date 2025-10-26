package ui;

import controller.OperationController;
import enums.SourceEnum;
import exeption.InvalidSourceException;
import util.HandleInput;
import util.ValidatInput;

public class DepositUI implements UI{
    private final OperationController controller;

    public DepositUI(OperationController controller){
        this.controller = controller;
    }

    @Override
    public void start() throws InvalidSourceException{
        try {
            int choice;
            showMenu();
            choice = HandleInput.getInt("Enter your choice: ");

            SourceEnum source = null;

            switch (choice){
                case 1 : {
                    source = SourceEnum.EXTERNAL_TRANSFER;
                }
                case 2 : {
                    source = SourceEnum.CASH_DEPOSIT;
                }
                case 3 : {
                    source = SourceEnum.SALARY;
                }
                case 4 : {
                    break;
                }
                default: {
                    throw new InvalidSourceException("Invalid Source!");
                }
            }

            String code = HandleInput.getString("Enter the account code: ");
            ValidatInput.isValidCode(code);

            double amount = HandleInput.getDouble("Enter the amount: ");
            ValidatInput.isValidAmount(amount);

            controller.deposit(code, amount, source);
        }catch (Exception e){
            System.err.println("Unexpected Error : " + e.getMessage());
        }
    }

    @Override
    public void showMenu(){
        System.out.println("1. External Transfer Deposit");
        System.out.println("2. Cash Deposit");
        System.out.println("3. Salary Deposit");
        System.out.println("4. Back To Main Menu");
    }

}
