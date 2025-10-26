package dto;

import java.util.ArrayList;
import java.util.List;

public abstract class AccountDTO {
    private String code;
    private String userName;
    private double balance;
    private List<OperationDTO> operationsList = new ArrayList<>();

    public String getCode(){
        return this.code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public List<OperationDTO> getOperationsList(){
        return operationsList;
    }

    public void setOperationsList(List<OperationDTO> operationsList){
        this.operationsList = operationsList;
    }

    public void displayDetails(){
        System.out.println("========================================");
        System.out.printf("| %-12s | %s%n", "Code", getCode());
        System.out.printf("| %-12s | %s%n", "Name", getUserName());
        if (this instanceof CurrentAccountDTO) {
            System.out.printf("| %-12s | Current Account%n", "Type");
            System.out.printf("| %-12s | %.2f DH%n", "overdraft", ((CurrentAccountDTO)this).getOverdraft());
        } else if (this instanceof SavingAccountDTO) {
            System.out.printf("| %-12s | Saving Account%n", "Type");
            System.out.printf("| %-12s | %.2f %% %n", "interest rate", ((SavingAccountDTO)this).getInterestRate() * 100);
        }
        System.out.printf("| %-12s | %.2f DH%n", "Balance", getBalance());
        System.out.println("========================================");
    }
}
