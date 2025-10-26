package dto;

import enums.DestinationEnum;

public class WithdrawalDTO extends OperationDTO{
    private DestinationEnum destination;

    public DestinationEnum getDestination() {
        return destination;
    }

    public void setDestination(DestinationEnum destination){
        this.destination = destination;
    }
}
