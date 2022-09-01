package Fakes;

import netflix.SubscriptionPlan;
import service.BillingService;

public class BillingServiceFake extends BillingService {

    public double amount;
    @Override
    public void billDetails(double amount) {
        this.amount=amount;
    }
}
