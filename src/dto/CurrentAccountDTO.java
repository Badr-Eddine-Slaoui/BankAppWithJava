package dto;

public class CurrentAccountDTO extends AccountDTO{
    private static final double overdraft = -300;

    public double getOverdraft(){
        return overdraft;
    }
}
