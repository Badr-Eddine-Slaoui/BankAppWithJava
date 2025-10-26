package dto;

import enums.SourceEnum;

public class DepositDTO extends OperationDTO {
    private SourceEnum source;

    public SourceEnum getSource() {
        return source;
    }

    public void setSource(SourceEnum source){
        this.source = source;
    }
}
