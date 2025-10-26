package dto;


public abstract class OperationDTO {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Operation [");

        if (this instanceof DepositDTO) {
            sb.append("Type: Deposit")
                    .append(", Source=").append(((DepositDTO) this).getSource());
        } else if (this instanceof WithdrawalDTO) {
            sb.append("Type: Withdrawal")
                    .append(", Destination=").append(((WithdrawalDTO) this).getDestination());
        } else if (this instanceof TransferDTO) {
            sb.append("Type: Transfer")
                    .append(", Receiver=").append(((TransferDTO) this).getReceiverCode())
                    .append(", Sender=").append(((TransferDTO) this).getSenderCode());
        }

        sb.append(", Amount=").append(this.getAmount());

        sb.append("]");
        return sb.toString();
    }
}
