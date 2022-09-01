package payment;

//DO NOT CHANGE
public interface IPaymentGateway {
    TransactionStatus pay(double amount);
}
