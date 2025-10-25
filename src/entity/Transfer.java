package entity;

public class Transfer extends Operation{
    private final String senderCode;
    private final String receiverCode;

    public Transfer(double amount, String senderCode, String receiverCode){
        super(amount);
        this.senderCode = senderCode;
        this.receiverCode = receiverCode;
    }

    public String getSenderCode(){
        return this.senderCode;
    }

    public String getReceiverCode(){
        return this.receiverCode;
    }
}
