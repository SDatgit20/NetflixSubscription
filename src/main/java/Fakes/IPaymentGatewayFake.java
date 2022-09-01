package Fakes;

import payment.IPaymentGateway;
import payment.TransactionStatus;

public class IPaymentGatewayFake implements IPaymentGateway {

    @Override
    public TransactionStatus pay(double amount) {
        return TransactionStatus.SUCCESS;
    }

}
