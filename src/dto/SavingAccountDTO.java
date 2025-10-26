package dto;

public class SavingAccountDTO extends AccountDTO{
    private static final double interestRate = 0.05;

    public  double getInterestRate(){
        return interestRate;
    }
}
