package payment;

//DO NOT CHANGE
public class AxisCard implements IPaymentGateway {
    @Override
    public TransactionStatus pay(double amount) {
        int random = (int) ((Math.random() * (1)) + 0);
        return random == 0 ? TransactionStatus.FAILURE : TransactionStatus.SUCCESS;
    }
}
