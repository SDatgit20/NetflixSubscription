package netflix;

import payment.IPaymentGateway;
import payment.TransactionStatus;
import service.BillingService;

public class Subscription {
    int id;
    SubscriptionPlan subscriptionPlan;
    BillingService billingService;
    IPaymentGateway paymentGateway;

    SubscriptionStatus subscriptionStatus;

    public Subscription(int id, SubscriptionPlan subscriptionPlan, BillingService billingService, IPaymentGateway iPaymentGateway) {
        this.id = id;
        this.subscriptionPlan = subscriptionPlan;
        this.billingService=billingService;
        paymentGateway=iPaymentGateway;
    }

    public void activate() {
        // write code to display bill details
        billingService.billDetails(subscriptionPlan.getPrice());
        if(paymentGateway.pay(subscriptionPlan.getPrice())== TransactionStatus.SUCCESS){
            this.subscriptionStatus=SubscriptionStatus.ACTIVE;
        }
    }

    public boolean isActive() {
        return subscriptionStatus==SubscriptionStatus.ACTIVE;
    }
}
