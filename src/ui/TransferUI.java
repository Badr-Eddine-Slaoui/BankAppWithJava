package ui;

import controller.OperationController;
import util.HandleInput;
import util.ValidatInput;

public class TransferUI implements UI{

    private final OperationController controller;

    public TransferUI(OperationController controller){
        this.controller = controller;
    }
    @Override
    public void start(){
        try {
            String senderCode = HandleInput.getString("Enter the sender code: ");
            ValidatInput.isValidCode(senderCode);

            String receiverCode = HandleInput.getString("Enter the receiver code: ");
            ValidatInput.isValidCode(receiverCode);

            double amount = HandleInput.getDouble("Enter the amount: ");
            ValidatInput.isValidAmount(amount);

            controller.transfer(senderCode, receiverCode, amount);
        } catch (Exception e) {
            System.out.println("Unexpected Error : " + e.getMessage());
        }
    }

    @Override
    public void showMenu(){}

}
